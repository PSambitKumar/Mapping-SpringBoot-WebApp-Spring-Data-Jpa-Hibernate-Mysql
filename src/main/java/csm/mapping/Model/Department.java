package csm.mapping.Model;

import javax.persistence.*;

/**
 * @Project : Mapping
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 04/09/2022 - 1:29 PM
 */

@Table
@Entity
public class Department {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int departmentId;
	private String departmentName;

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	@Override
	public String toString() {
		return "Department{" +
			   "departmentId=" + departmentId +
			   ", departmentName='" + departmentName + '\'' +
			   '}';
	}
}
