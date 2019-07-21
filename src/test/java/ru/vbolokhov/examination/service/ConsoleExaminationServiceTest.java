package ru.vbolokhov.examination.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.vbolokhov.examination.domain.Answer;
import ru.vbolokhov.examination.domain.Question;
import ru.vbolokhov.examination.domain.Result;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import static org.junit.Assert.*;

/**
 * Tests for ConsoleExaminationService.
 * @author Vadim Bolokhov
 */
public class ConsoleExaminationServiceTest {

    private InputStream stdIn = System.in;

    private PrintStream stdOut = System.out;

    @Before
    public void setUp() {
        String input = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("John")
                .add("Johnson")
                .add("1")
                .toString();
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        System.setOut(new PrintStream(new ByteArrayOutputStream()));
    }

    @After
    public void revertChanges() {
        System.setIn(this.stdIn);
        System.setOut(this.stdOut);
    }

    @Test
    public void whenPerformExaminationThenShouldReturnResult() {
        Answer answer = new Answer(1, "Answer");
        Question question = new Question("Question");
        question.addAnswer(answer);
        question.setCorrectId(1);
        List<Question> list = new ArrayList<>();
        list.add(question);
        ConsoleExaminationService service = new ConsoleExaminationService();
        Result result = service.performExamination(list);
        Map<Question, Integer> resultMap = result.getResultMap();
        assertEquals(result.getStudent().getFirstname(), "John");
        assertEquals(result.getStudent().getLastname(), "Johnson");
        assertEquals(resultMap.get(question), Integer.valueOf(1));
    }
}