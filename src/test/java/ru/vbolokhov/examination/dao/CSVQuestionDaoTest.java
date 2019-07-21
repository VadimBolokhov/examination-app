package ru.vbolokhov.examination.dao;

import org.junit.Test;
import ru.vbolokhov.examination.domain.Question;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Tests for CSVQuestionDao.
 * @author Vadim Bolokhov
 */
public class CSVQuestionDaoTest {

    @Test
    public void whenGetQuestionsThenShouldReturnQuestionList() throws IOException {
        try (Reader reader = new StringReader("Test,1,100,200,300")) {
            CSVQuestionDao dao = new CSVQuestionDao(reader);
            List<Question> result = dao.getQuestions();
            Question question = result.get(0);
            assertEquals(question.getMessage(), "Test");
            assertEquals(question.getCorrectId(), 1);
        }
    }
}