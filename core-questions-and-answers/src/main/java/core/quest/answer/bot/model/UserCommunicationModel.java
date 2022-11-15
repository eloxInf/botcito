package core.quest.answer.bot.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "user_communication")
public class UserCommunicationModel {
	
	@Field("_id")
	String id;
	
	@Field("idMessage")
	String idMessage;
	
	@Field("soruceMessage")
	String soruceMessage;
	
	@Field("identificationUser")
	String identificationUser;
	
	@Field("message")
	String message;
	
	@Field("platform")
	String platform;
	
	@Field("answereProperty.idParentMje")
	String idParentMje;
	
	@Field("answereProperty.is_valid_answer")
	String is_valid_answer;
	
}
