package ru.vbolokhov.examination.service;

import ru.vbolokhov.examination.dao.QuestionDao;
import ru.vbolokhov.examination.domain.Question;

import java.util.List;

/**
 * Basic implementation of QuestionService interface.
 * @author Vadim Bolokhov
 */
public class SimpleQuestionService implements QuestionService {

    private QuestionDao qDao;

    public SimpleQuestionService(QuestionDao qDao) {
        this.qDao = qDao;
    }

    @Override
    public List<Question> getQuestionList() {
        return this.qDao.getQuestions();
    }
}
