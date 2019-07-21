package ru.vbolokhov.examination.service;

import ru.vbolokhov.examination.dao.QuestionDao;
import ru.vbolokhov.examination.domain.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Class StubQuestionDao.
 * @author Vadim Bolokhov
 */
public class StubQuestionDao implements QuestionDao {

    private List<Question> list = new ArrayList<>();

    @Override
    public List<Question> getQuestions() {
        return this.list;
    }

    @Override
    public Optional<Question> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void add(Question question) {
        this.list.add(question);
    }

    @Override
    public void update(Question question) {

    }

    @Override
    public void delete(int id) {

    }
}
