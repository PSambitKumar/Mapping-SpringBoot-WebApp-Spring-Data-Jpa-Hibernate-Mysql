package csm.mapping.Model;

import javax.persistence.*;
import java.util.List;

/**
 * @Project : Mapping
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 04/09/2022 - 1:26 PM
 */

@Entity
@Table
public class College {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int collegeId;
	private String collegeName;
	@OneToMany
	@JoinColumn(name = "collegeId")
	private List<Department> departmentList;


	public int getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public List<Department> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}

	@Override
	public String toString() {
		return "College{" +
			   "collegeId=" + collegeId +
			   ", collegeName='" + collegeName + '\'' +
			   ", departmentList=" + departmentList +
			   '}';
	}
}
