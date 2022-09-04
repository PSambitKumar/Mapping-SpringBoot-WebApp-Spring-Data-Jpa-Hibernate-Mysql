package csm.mapping.Model;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.RowId;

import javax.persistence.*;

/**
 * @Project : Mapping
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 03/09/2022 - 10:20 PM
 */
@Entity
@Table(name = "answer")
public class Answer {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int answerId;
	private String answer;
	@ManyToOne
	private Question question;

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}


}
