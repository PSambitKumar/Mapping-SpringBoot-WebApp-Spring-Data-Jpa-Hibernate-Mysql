package csm.mapping.Repository;

import csm.mapping.Model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Project : Mapping
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 03/09/2022 - 10:40 PM
 */
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
