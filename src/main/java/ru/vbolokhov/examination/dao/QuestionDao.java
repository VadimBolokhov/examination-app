package ru.vbolokhov.examination.dao;

import ru.vbolokhov.examination.domain.Question;

import java.util.List;
import java.util.Optional;

/**
 * DAO interface for question related queries
 * @author Vadim Bolokhov
 */
public interface QuestionDao {

    /**
     * Returns a list of questions.
     * @return List of questions
     */
    List<Question> getQuestions();

    /**
     * Reads a question by ID
     * @param id The question ID
     * @return Optional with question or empty optional otherwise
     */
    Optional<Question> findById(int id);

    /**
     * Stores a question.
     * @param question the question
     */
    void add(Question question);

    /**
     * Updates a question
     * @param question the question
     */
    void update(Question question);

    /**
     * Deletes a question.
     * @param id question id
     */
    void delete(int id);
}
