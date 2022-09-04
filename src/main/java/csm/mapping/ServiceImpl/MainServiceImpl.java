package csm.mapping.ServiceImpl;

import csm.mapping.Model.ProgrammingQuestion;
import csm.mapping.Repository.ProgrammingAnswerRepository;
import csm.mapping.Repository.ProgrammingQuestionRepository;
import csm.mapping.Service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Project : Mapping
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 04/09/2022 - 1:54 PM
 */

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	private ProgrammingQuestionRepository programmingQuestionRepository;
	@Autowired
	private ProgrammingAnswerRepository programmingAnswerRepository;

	@Override
	public ProgrammingQuestion saveProgrammingQuestion(ProgrammingQuestion programmingQuestion) {
		return programmingQuestionRepository.save(programmingQuestion);
	}

	@Override
	public List<ProgrammingQuestion> getAllProgrammingQuestion() {
		return programmingQuestionRepository.findAll();
	}

	@Override
	public ProgrammingQuestion getProgrammingQuestionById(int programmingQuestionId) {
		return programmingQuestionRepository.findById(programmingQuestionId).get();
	}
}
