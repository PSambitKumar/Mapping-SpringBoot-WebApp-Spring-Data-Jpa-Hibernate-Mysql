package csm.mapping.Model;

import javax.persistence.*;
import java.util.List;

/**
 * @Project : Mapping
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 04/09/2022 - 1:57 PM
 */

@Entity
@Table
public class ProgrammingQuestion {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int programmingQuestionId;
	@Lob
	private String programmingQuestionName;
	@OneToMany
	@JoinColumn(name = "programmingQuestionId")
	private List<ProgrammingAnswer> programmingAnswerList;

	public int getProgrammingQuestionId() {
		return programmingQuestionId;
	}

	public void setProgrammingQuestionId(int programmingQuestionId) {
		this.programmingQuestionId = programmingQuestionId;
	}

	public String getProgrammingQuestionName() {
		return programmingQuestionName;
	}

	public void setProgrammingQuestionName(String programmingQuestionName) {
		this.programmingQuestionName = programmingQuestionName;
	}

	public List<ProgrammingAnswer> getProgrammingAnswerList() {
		return programmingAnswerList;
	}

	public void setProgrammingAnswerList(List<ProgrammingAnswer> programmingAnswerList) {
		this.programmingAnswerList = programmingAnswerList;
	}

	@Override
	public String toString() {
		return "ProgrammingQuestion{" +
			   "programmingQuestionId=" + programmingQuestionId +
			   ", programmingQuestionName='" + programmingQuestionName + '\'' +
			   ", programmingAnswerList=" + programmingAnswerList +
			   '}';
	}
}
