package ru.vbolokhov.examination.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Tests for Result.
 * @author Vadim Bolokhov
 */
public class ResultTest {

    private Student student;

    private Result result;

    @Before
    public void setUp() {
        this.student = new Student("John", "Test");
        result = new Result(student);
    }

    @Test
    public void testAddAnswer() {
        Question question = this.createQuestion();
        assertTrue(this.result.getResultMap().isEmpty());
        this.result.addAnswer(question, 555);
        Map<Question, Integer> map = this.result.getResultMap();
        assertThat(this.result.getResultMap().get(question), is(555));
    }

    private Question createQuestion() {
        Answer answer = new Answer(555, "Answer");
        Question question = new Question("Question");
        question.setId(111);
        question.addAnswer(answer);
        return question;
    }

    @Test
    public void testGetIncorrectAnswers() {
        Question question = this.createQuestion();
        question.setCorrectId(555);
        this.result.addAnswer(question, 111);
        Map<Question, Integer> incorrect = this.result.getIncorrectAnswers();
        Map<Question, Integer> correct = this.result.getCorrectAnswers();
        assertThat(incorrect.get(question), is(111));
        assertTrue(correct.isEmpty());
    }

    @Test
    public void testSetStudent() {
        Student s1 = new Student("John", "Johnson");
        Result result = new Result(s1);
        assertEquals(result.getStudent(), s1);
        Student s2 = new Student("Jack", "Jackson");
        result.setStudent(s2);
        assertEquals(result.getStudent(), s2);
    }
}