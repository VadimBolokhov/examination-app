package ru.vbolokhov.examination.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Examination result.
 * @author Vadim Bolokhov
 */
public class Result {
    /** Student */
    private Student student;
    /** Result map */
    private Map<Question, Integer> result = new LinkedHashMap<>();

    public Result(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * Add student's answer to a question.
     * @param question question to be answered by student
     * @param answerId answer id
     */
    public void addAnswer(Question question, int answerId) {
        this.result.put(question, answerId);
    }

    /**
     * Returns all student's answers
     * @return student's answers
     */
    public Map<Question, Integer> getResultMap() {
        return this.result;
    }

    /**
     * Returns student's incorrect answers
     * @return incorrect answers
     */
    public Map<Question, Integer> getIncorrectAnswers() {
        return this.getUserAnswers(entry -> entry.getKey().getCorrectId() != entry.getValue());
    }

    private Map<Question, Integer> getUserAnswers(Predicate<Map.Entry<Question, Integer>> predicate) {
        return this.result.entrySet().stream()
                .filter(predicate)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    /**
     * Returns student's correct answers
     * @return correct answers
     */
    public Map<Question, Integer> getCorrectAnswers() {
        return this.getUserAnswers(entry -> entry.getKey().getCorrectId() == entry.getValue());
    }
}
