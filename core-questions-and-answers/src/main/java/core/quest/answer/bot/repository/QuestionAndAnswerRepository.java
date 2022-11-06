package core.quest.answer.bot.repository;

import org.springframework.stereotype.Repository;

import core.quest.answer.bot.model.QuestionAndAnswer;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

@Repository
public interface QuestionAndAnswerRepository extends MongoRepository<QuestionAndAnswer, String> {

	
	List<QuestionAndAnswer> findByUserMessage(String userMessage);
	
	List<QuestionAndAnswer> findByInternalCode(String internalCode);
	
}
