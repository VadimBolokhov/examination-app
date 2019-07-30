package ru.vbolokhov.examination.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.vbolokhov.examination.domain.Answer;
import ru.vbolokhov.examination.domain.Question;
import ru.vbolokhov.examination.domain.Result;
import ru.vbolokhov.examination.domain.Student;

import java.util.*;

/**
 * Console based implementation for ExaminationService.
 * @author Vadim Bolokhov
 */
@Service
@ConditionalOnProperty(
        value = "application.UI",
        havingValue = "console"
)
public class ConsoleExaminationService implements ExaminationService {

    private Scanner scanner = new Scanner(System.in);

    private Map<Integer, Locale> locales = new HashMap<>();

    private Locale currentLocale = Locale.ENGLISH;

    private MessageSource messageSource;

    @Autowired
    public ConsoleExaminationService(MessageSource messageSource) {
        this.locales.put(1, Locale.ENGLISH);
        this.locales.put(2, new Locale("ru", "RU"));
        this.messageSource = messageSource;
    }

    @Override
    public Result performExamination(List<Question> questions) {
        this.setLocale();
        Result result = new Result(this.getStudent());
        int correctAnswers = 0;
        for (Question question : questions) {
            int id = this.getAnswer(question);
            if (id == question.getCorrectId()) {
                correctAnswers++;
            }
            result.addAnswer(question, id);
        }
        this.showMessage(
                "info.result",
                new String[] {String.valueOf(correctAnswers), String.valueOf(questions.size())}
                );
        return result;
    }

    private void setLocale() {
        System.out.println("Choose your language:");
        System.out.println("\t1. English");
        System.out.println("\t2. Русский");
        int select = this.getValidAnswer(2);
        this.currentLocale = this.locales.get(select);
    }

    private int getValidAnswer(int max) {
        int userAnswer = -1;
        boolean valid = false;
        do {
            String input = scanner.nextLine();
            try {
                userAnswer = Integer.parseInt(input);
                if (userAnswer > 0 && userAnswer <= max) {
                    valid = true;
                } else {
                    this.showMessage("ask.valid");
                }
            } catch (NumberFormatException e) {
                this.showMessage("ask.int");
            }
        } while (!valid);
        return userAnswer;
    }

    private Student getStudent() {
        this.showMessage("ask.firstname");
        String firstname = this.scanner.nextLine();
        this.showMessage("ask.lastname");
        String lastname = this.scanner.nextLine();
        return new Student(firstname.trim(), lastname.trim());
    }

    private void showMessage(String property) {
        this.showMessage(property, null);
    }

    private void showMessage(String property, String[] params) {
        System.out.println(
                this.messageSource.getMessage(
                        property,
                        params,
                        this.currentLocale
                )
        );
    }

    private int getAnswer(Question question) {
        this.showQuestion(question);
        int userAnswer = this.getValidAnswer(question.getAnswers().size());
        return question.getAnswers().get(userAnswer - 1).getId();
    }

    private void showQuestion(Question question) {
        System.out.println(question.getMessage());
        List<Answer> answers = question.getAnswers();
        for (int i = 1; i <= answers.size(); i++) {
            System.out.println("\t" + i + ". " + answers.get(i - 1).getValue());
        }
    }
}
