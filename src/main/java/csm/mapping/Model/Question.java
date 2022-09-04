package csm.mapping.Model;

import jdk.internal.dynalink.linker.LinkerServices;

import javax.persistence.*;
import java.util.List;

/**
 * @Project : Mapping
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 03/09/2022 - 10:16 PM
 */
@Entity
@Table(name = "question")
public class Question {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int questionId;
	private String question;
	@OneToMany(mappedBy = "question")
	private List<Answer> answerList;


	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Answer> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}


}
