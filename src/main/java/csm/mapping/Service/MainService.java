package csm.mapping.Service;

import csm.mapping.Model.ProgrammingQuestion;

import java.util.List;

/**
 * @Project : Mapping
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 04/09/2022 - 1:54 PM
 */
public interface MainService {
	ProgrammingQuestion saveProgrammingQuestion(ProgrammingQuestion programmingQuestion);
	List<ProgrammingQuestion> getAllProgrammingQuestion();
	ProgrammingQuestion getProgrammingQuestionById(int programmingQuestionId);
}
