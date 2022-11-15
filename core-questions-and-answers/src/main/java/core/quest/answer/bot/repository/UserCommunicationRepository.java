package core.quest.answer.bot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import core.quest.answer.bot.model.UserCommunicationModel;

@Repository
public interface UserCommunicationRepository extends MongoRepository<UserCommunicationModel, String> {

	
}
