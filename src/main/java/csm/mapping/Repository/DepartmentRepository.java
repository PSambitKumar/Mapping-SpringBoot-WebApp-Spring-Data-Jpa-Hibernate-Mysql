package csm.mapping.Repository;

import csm.mapping.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Project : Mapping
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 04/09/2022 - 1:36 PM
 */
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
