package ru.vbolokhov.examination.domain;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;

/**
 * Tests for Answer.
 * @author Vadim Bolokhov
 */
public class AnswerTest {

    private Answer answer;

    @Before
    public void setUp() {
        answer = new Answer();
    }

    @Test
    public void testSetId() {
        assertEquals(this.answer.getId(), 0);
        this.answer.setId(1);
        assertEquals(this.answer.getId(), 1);
    }

    @Test
    public void testSetValue() {
        assertNull(this.answer.getValue());
        this.answer.setValue("Test");
        assertEquals(this.answer.getValue(), "Test");
    }
}