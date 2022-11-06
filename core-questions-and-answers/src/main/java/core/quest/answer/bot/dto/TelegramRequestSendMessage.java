package core.quest.answer.bot.dto;

import lombok.Data;

@Data
public class TelegramRequestSendMessage {
	
	private String chatId;
	private String message;

}
