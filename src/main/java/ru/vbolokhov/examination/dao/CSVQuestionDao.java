package ru.vbolokhov.examination.dao;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import ru.vbolokhov.examination.domain.Answer;
import ru.vbolokhov.examination.domain.Question;

import java.io.*;
import java.util.*;

/**
 * CSV file based implementation for QuestionDAO interface.
 * @author Vadim Bolokhov
 */
@Service("questionDao")
public class CSVQuestionDao implements QuestionDao {

    private List<Question> questions = new ArrayList<>();

    @Autowired
    public CSVQuestionDao(@Value("${questions.path}") String path) throws IOException {
        this(new File(path));
    }

    public CSVQuestionDao(File file) throws IOException {
        try (Reader in = new FileReader(file)) {
            this.parseTable(in);
        }
    }

    public CSVQuestionDao(Reader reader) throws IOException {
        this.parseTable(reader);
    }

    private void parseTable(Reader in) throws IOException {
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
        for (CSVRecord record : records) {
            this.parseRecord(record);
        }
    }

    private void parseRecord(CSVRecord record) {
        Question question = new Question();
        question.setMessage(record.get(0));
        String index = record.get(1);
        int correctIndex = this.parseIndex(index);
        for (int i = 1; i < record.size() - 1; i++) {
            Answer answer = new Answer(i, record.get(i + 1));
            if (i == correctIndex) {
                question.setCorrectId(i);
            }
            question.addAnswer(answer);
        }
        this.questions.add(question);
    }

    private int parseIndex(String index) {
        return Integer.parseInt(index);
    }

    @Override
    public List<Question> getQuestions() {
        return this.questions;
    }

    @Override
    public Optional<Question> findById(int id) {
        return this.questions.stream()
                .filter(q -> q.getId() == id)
                .findFirst();
    }

    @Override
    public void add(Question question) {
        throw new UnsupportedOperationException(
                "Current implementation of DAO interface does not support adding entities."
        );
    }

    @Override
    public void update(Question question) {
        throw new UnsupportedOperationException(
                "Current implementation of DAO interface does not support updating entities."
        );
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException(
                "Current implementation of DAO interface does not support deleting entities."
        );
    }

    @Bean
    public static PropertyPlaceholderConfigurer propertyConfigInDev() {
        return new PropertyPlaceholderConfigurer();
    }
}
