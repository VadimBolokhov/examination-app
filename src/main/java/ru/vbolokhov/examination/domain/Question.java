package ru.vbolokhov.examination.domain;

import java.util.*;

/**
 * A question.
 * @author Vadim Bolokhov
 */
public class Question {
    /** Question ID */
    private int id;
    /** Phrasing of the question */
    private String message;
    /** Correct answer ID */
    private int correctId;
    /** Answers */
    private List<Answer> answers = new ArrayList<>();

    public Question() {
    }

    public Question(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCorrectId(int correctId) {
        this.correctId = correctId;
    }

    public int getCorrectId() {
        return correctId;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public void addAnswer(Answer answer) {
        this.answers.add(answer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Question question = (Question) o;
        return id == question.id
                && Objects.equals(message, question.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message);
    }
}
