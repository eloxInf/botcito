package core.quest.answer.bot.repository;

import org.springframework.stereotype.Service;

import core.quest.answer.bot.model.QuestionAndAnswer;

import org.springframework.data.mongodb.repository.MongoRepository;

@Service
public interface QuestionAndAnswerRepository extends MongoRepository<QuestionAndAnswer, String> {

	QuestionAndAnswer findByUserMessage(String userMessage);
	
}
