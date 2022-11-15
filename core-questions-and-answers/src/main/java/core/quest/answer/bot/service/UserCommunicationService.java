package core.quest.answer.bot.service;


import core.quest.answer.bot.dto.ResponseBase;
import core.quest.answer.bot.dto.UserCommunicationDto;

public interface UserCommunicationService {


	ResponseBase saveCommunication(UserCommunicationDto requestInputMessage);


}
