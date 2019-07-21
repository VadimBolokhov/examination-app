package ru.vbolokhov.examination.domain;

import java.util.Objects;

/**
 * An answer.
 * @author Vadim Bolokhov
 */
public class Answer {
    private int id;

    private String value;

    public Answer() {
    }

    public Answer(String value) {
        this.value = value;
    }

    public Answer(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Answer answer = (Answer) o;
        return id == answer.id
                && Objects.equals(value, answer.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }
}
