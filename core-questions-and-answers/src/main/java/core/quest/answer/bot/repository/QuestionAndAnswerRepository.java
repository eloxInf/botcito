package core.quest.answer.bot.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import core.quest.answer.bot.model.QuestionAndAnswerModel;

@Repository
public interface QuestionAndAnswerRepository extends MongoRepository<QuestionAndAnswerModel, String> {

	
	List<QuestionAndAnswerModel> findByUserMessage(String userMessage);
	
	List<QuestionAndAnswerModel> findByInternalCode(String internalCode);
	
}
