package ru.vbolokhov.examination;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.vbolokhov.examination.domain.Question;
import ru.vbolokhov.examination.domain.Result;
import ru.vbolokhov.examination.service.ExaminationService;
import ru.vbolokhov.examination.service.QuestionService;

import java.util.List;

/**
 * The main loop.
 * @author Vadim Bolokhov
 */
public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("/spring-context.xml");
        QuestionService qService = context.getBean(QuestionService.class);
        List<Question> questions = qService.getQuestionList();
        ExaminationService exam = context.getBean(ExaminationService.class);
        Result result = exam.performExamination(questions);
    }
}
