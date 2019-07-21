package ru.vbolokhov.examination.service;

import ru.vbolokhov.examination.domain.Question;

import java.util.List;

/**
 * Interface QuestionService.
 * @author Vadim Bolokhov
 */
public interface QuestionService {

    /**
     * Returns a list of questions.
     * @return List of questions
     */
    List<Question> getQuestionList();
}
