package core.quest.answer.bot.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "question_and_answers")
public class QuestionAndAnswer {
	
	@Field("internalCode")
	String internalCode;
	
	@Field("userMessage")
	String userMessage;
	
	@Field("botMessage")
	String botMessage;
	
	@Field("actionCode")
	String actionCode;
}
