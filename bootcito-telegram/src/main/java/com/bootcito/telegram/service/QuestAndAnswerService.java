package com.bootcito.telegram.service;

import com.bootcito.telegram.dto.request.SendMessageCoreQuestAnsw;
import com.bootcito.telegram.dto.response.ResponseBaseStatus;

public interface QuestAndAnswerService {

	ResponseBaseStatus sendMessage(SendMessageCoreQuestAnsw sendMessageCoreQuestAnsw);

}
