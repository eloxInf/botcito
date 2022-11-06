package core.quest.answer.bot.service;

import core.quest.answer.bot.dto.ResponseBase;
import core.quest.answer.bot.dto.TelegramRequestSendMessage;

public interface TelegramService {

	ResponseBase sendMessage(TelegramRequestSendMessage telegramRequestSendMessage);

}
