package ru.vbolokhov.examination.service;

import org.junit.Before;
import org.junit.Test;
import ru.vbolokhov.examination.dao.QuestionDao;
import ru.vbolokhov.examination.domain.Answer;
import ru.vbolokhov.examination.domain.Question;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests for SimpleQuestionService.
 * @author Vadim Bolokhov
 */
public class SimpleQuestionServiceTest {

    private QuestionDao dao;

    @Before
    public void setUp() {
        this.dao = new StubQuestionDao();
    }

    @Test
    public void testGetQuestionList() {
        QuestionService service = new SimpleQuestionService(this.dao);
        assertTrue(service.getQuestionList().isEmpty());
        Question question = this.createQuestion();
        this.dao.add(question);
        assertEquals(service.getQuestionList().get(0).getId(), 111);
    }

    private Question createQuestion() {
        Answer answer = new Answer(555, "Answer");
        Question question = new Question("Question");
        question.setId(111);
        question.addAnswer(answer);
        return question;
    }
}