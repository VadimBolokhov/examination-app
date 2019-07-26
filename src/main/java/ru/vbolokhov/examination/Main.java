package ru.vbolokhov.examination;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.vbolokhov.examination.domain.Question;
import ru.vbolokhov.examination.domain.Result;
import ru.vbolokhov.examination.service.ExaminationService;
import ru.vbolokhov.examination.service.QuestionService;

import java.util.List;

@SpringBootApplication
public class Main {

	@Bean
	public MessageSource messageSource() {
		var ms = new ReloadableResourceBundleMessageSource();
		ms.setBasename("/i18n/bundle");
		ms.setDefaultEncoding("UTF-8");
		return ms;
	}

	public static void main(String[] args) {
		var context = SpringApplication.run(Main.class, args);
		try {
			QuestionService qService = context.getBean(QuestionService.class);
			List<Question> questions = qService.getQuestionList();
			ExaminationService exam = context.getBean(ExaminationService.class);
			Result result = exam.performExamination(questions);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
