package csm.mapping.Repository;

import csm.mapping.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Project : Mapping
 * @Auther : Sambit Kumar Pradhan
 * @Created On : 03/09/2022 - 10:38 PM
 */
public interface QuestionRepository extends JpaRepository<Question, Integer> {
	Question getQuestionsByQuestionId(int questionId);
}
