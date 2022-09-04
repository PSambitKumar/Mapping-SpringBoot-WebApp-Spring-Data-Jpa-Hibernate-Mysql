package csm.mapping.Repository;

import csm.mapping.Model.ProgrammingQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Project : Mapping
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 04/09/2022 - 2:15 PM
 */
public interface ProgrammingQuestionRepository extends JpaRepository<ProgrammingQuestion, Integer> {
}
