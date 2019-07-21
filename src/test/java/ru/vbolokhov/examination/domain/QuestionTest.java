package ru.vbolokhov.examination.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for Question.
 * @author Vadim Bolokhov
 */
public class QuestionTest {

    private Question question;

    @Before
    public void setUp() {
        this.question = new Question();
    }

    @Test
    public void testSetId() {
        assertEquals(this.question.getId(), 0);
        this.question.setId(10);
        assertEquals(this.question.getId(), 10);
    }

    @Test
    public void setMessage() {
        assertNull(this.question.getMessage());
        this.question.setMessage("Test");
        assertEquals(this.question.getMessage(), "Test");
    }

    @Test
    public void testSetCorrectId() {
        assertEquals(this.question.getCorrectId(), 0);
        this.question.setCorrectId(10);
        assertEquals(this.question.getCorrectId(), 10);
    }

    @Test
    public void testAddAnswer() {
        assertTrue(this.question.getAnswers().isEmpty());
        Answer answer = new Answer("Test");

        this.question.addAnswer(answer);

        assertEquals(this.question.getAnswers().get(0).getValue(), "Test");
    }
}