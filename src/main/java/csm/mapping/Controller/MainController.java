package csm.mapping.Controller;

import csm.mapping.Model.*;
import csm.mapping.Repository.AnswerRepository;
import csm.mapping.Repository.CollegeRepository;
import csm.mapping.Repository.DepartmentRepository;
import csm.mapping.Repository.QuestionRepository;
import csm.mapping.Service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.GeneratedValue;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Project : Mapping
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 03/09/2022 - 9:42 PM
 */
@Controller
public class MainController {

	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private AnswerRepository answerRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private CollegeRepository collegeRepository;
	@Autowired
	private MainService mainService;

	@GetMapping(value = "/createQuestion")
	public String createQuestion() {
		Question question = new Question();
		question.setQuestion("What is Java?");

		Answer answer = new Answer();
		answer.setAnswer("Java is a programming language");
		answer.setQuestion(question);

		Answer answer1 = new Answer();
		answer1.setAnswer("Java is a platform");
		answer1.setQuestion(question);

		Answer answer2 = new Answer();
		answer2.setAnswer("Java ihas many frameworks");
		answer2.setQuestion(question);


		List<Answer> answerList = new ArrayList<>();
		answerList.add(answer);
		answerList.add(answer1);
		answerList.add(answer2);

		question.setAnswerList(answerList);

		Question question1 = questionRepository.save(question);
		answerRepository.save(answer);
		answerRepository.save(answer1);
		answerRepository.save(answer2);


		System.out.println(question1);
		question1.getAnswerList().forEach(Answer -> System.out.println(Answer.getAnswer()));
		return null;
	}

	@GetMapping(value = "/addDepartment")
	public String addDepartment(){

		College college = new College();
		college.setCollegeName("Kathmandu University");

		Department department = new Department();
		department.setDepartmentName("Computer Science");

		Department department1 = new Department();
		department1.setDepartmentName("Electrical Engineering");

		List<Department> departmentList = new ArrayList<>();
		departmentList.add(department);
		departmentList.add(department1);

		college.setDepartmentList(departmentList);

		departmentRepository.save(department);
		departmentRepository.save(department1);

		collegeRepository.save(college);

		College college1 = collegeRepository.getReferenceById(1);
		System.out.println(college1);
		return null;

	}

	@GetMapping(value = "/addProgrammingQuestion")
	public String addProgrammingQuestion(Model model){
		List<ProgrammingQuestion> programmingQuestionList = mainService.getAllProgrammingQuestion();
		model.addAttribute("programmingQuestionList", programmingQuestionList);
		return "addProgrammingQuestion";
	}

	@PostMapping(value = "/addProgrammingQuestion")
	public String addProgrammingQuestion(ProgrammingQuestion programmingQuestion, Model model){
		System.out.println("Inside Add Programming Question------------->>");
		System.out.println("Programming Question: "+programmingQuestion);
		mainService.saveProgrammingQuestion(programmingQuestion);
		List<ProgrammingQuestion> programmingQuestionList = mainService.getAllProgrammingQuestion();
		model.addAttribute("programmingQuestionList", programmingQuestionList);
		return "addProgrammingQuestion";
	}

	@GetMapping(value = "/getProgrammingQuestion")
	public String getProgrammingQuestion(@RequestParam(value = "programmingQuestionId", required = false) Integer programmingQuestionId, Model model){
		System.out.println("Inside Get Programming Question------------->>");
		System.out.println("Programming Question Id: "+programmingQuestionId);
		ProgrammingQuestion programmingQuestion = mainService.getProgrammingQuestionById(programmingQuestionId);
		System.out.println("Programming Question: "+programmingQuestion);
		return null;
	}



}
