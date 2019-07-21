package ru.vbolokhov.examination.service;

import ru.vbolokhov.examination.domain.Question;
import ru.vbolokhov.examination.domain.Result;

import java.util.List;

/**
 * Interface ExaminationService.
 * @author Vadim Bolokhov
 */
public interface ExaminationService {

    Result performExamination(List<Question> questions);
}
