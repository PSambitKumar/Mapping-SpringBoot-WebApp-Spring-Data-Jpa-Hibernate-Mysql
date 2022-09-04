package csm.mapping.Model;

import javax.persistence.*;

/**
 * @Project : Mapping
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 04/09/2022 - 1:59 PM
 */

@Entity
@Table
public class ProgrammingAnswer {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int programmingAnswerId;
	private String programmingAnswerName;

	public int getProgrammingAnswerId() {
		return programmingAnswerId;
	}

	public void setProgrammingAnswerId(int programmingAnswerId) {
		this.programmingAnswerId = programmingAnswerId;
	}

	public String getProgrammingAnswerName() {
		return programmingAnswerName;
	}

	public void setProgrammingAnswerName(String programmingAnswerName) {
		this.programmingAnswerName = programmingAnswerName;
	}

	@Override
	public String toString() {
		return "ProgrammingAnswer{" +
			   "programmingAnswerId=" + programmingAnswerId +
			   ", programmingAnswerName='" + programmingAnswerName + '\'' +
			   '}';
	}
}
