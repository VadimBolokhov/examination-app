package ru.vbolokhov.examination.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.vbolokhov.examination.dao.QuestionDao;
import ru.vbolokhov.examination.domain.Question;

import java.util.List;

/**
 * Basic implementation of QuestionService interface.
 * @author Vadim Bolokhov
 */
@Service("questionService")
public class SimpleQuestionService implements QuestionService {

    private final QuestionDao qDao;

    @Autowired
    public SimpleQuestionService(@Qualifier("questionDao") QuestionDao qDao) {
        this.qDao = qDao;
    }

    @Override
    public List<Question> getQuestionList() {
        return this.qDao.getQuestions();
    }
}
