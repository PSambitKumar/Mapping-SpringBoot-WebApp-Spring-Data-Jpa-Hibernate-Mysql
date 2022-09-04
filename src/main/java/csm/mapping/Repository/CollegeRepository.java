package csm.mapping.Repository;

import csm.mapping.Model.College;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Project : Mapping
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 04/09/2022 - 1:35 PM
 */
public interface CollegeRepository extends JpaRepository<College, Integer> {
}
