package ru.vbolokhov.examination.service;

import ru.vbolokhov.examination.domain.Answer;
import ru.vbolokhov.examination.domain.Question;
import ru.vbolokhov.examination.domain.Result;
import ru.vbolokhov.examination.domain.Student;

import java.util.List;
import java.util.Scanner;

/**
 * Console based implementation for ExaminationService.
 * @author Vadim Bolokhov
 */
public class ConsoleExaminationService implements ExaminationService {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public Result performExamination(List<Question> questions) {
        Result result = new Result(this.getStudent());
        int correctAnswers = 0;
        for (Question question : questions) {
            int id = this.getAnswer(question);
            if (id == question.getCorrectId()) {
                correctAnswers++;
            }
            result.addAnswer(question, id);
        }
        System.out.println(
                String.format("You answered correctly %d of %d questions",
                        correctAnswers,
                        questions.size()));
        return result;
    }

    private Student getStudent() {
        System.out.println("Enter your first name:");
        String firstname = this.scanner.nextLine();
        System.out.println("Enter your last name:");
        String lastname = this.scanner.nextLine();
        return new Student(firstname, lastname);
    }

    private int getAnswer(Question question) {
        this.showQuestion(question);
        int answerId = -1;
        boolean valid = false;
        while (!valid) {
            String input = scanner.nextLine();
            try {
                int userAnswer = Integer.parseInt(input);
                if (userAnswer > 0 && userAnswer <= question.getAnswers().size()) {
                    answerId = question.getAnswers().get(userAnswer - 1).getId();
                    valid = true;
                } else {
                    System.out.println("Please enter valid value");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter integer value");
            }
        }
        return answerId;
    }

    private void showQuestion(Question question) {
        System.out.println(question.getMessage());
        List<Answer> answers = question.getAnswers();
        for (int i = 1; i <= answers.size(); i++) {
            System.out.println("\t" + i + ". " + answers.get(i - 1).getValue());
        }
    }
}
