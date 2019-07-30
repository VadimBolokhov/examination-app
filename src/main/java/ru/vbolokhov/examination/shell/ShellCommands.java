package ru.vbolokhov.examination.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.vbolokhov.examination.domain.Question;
import ru.vbolokhov.examination.domain.Result;
import ru.vbolokhov.examination.service.ExaminationService;
import ru.vbolokhov.examination.service.QuestionService;

import java.util.List;

/**
 * ShellCommands class.
 * @author Vadim Bolokhov
 */
@ShellComponent
public class ShellCommands {

    private final QuestionService questionService;

    private final ExaminationService examinationService;

    @Autowired
    public ShellCommands(QuestionService qService, ExaminationService eService) {
        this.questionService = qService;
        this.examinationService = eService;
    }

    @ShellMethod(value = "Start test", key = {"start", "st"})
    public void startTest() {
        List<Question> questions = this.questionService.getQuestionList();
        Result result = this.examinationService.performExamination(questions);
    }
}
