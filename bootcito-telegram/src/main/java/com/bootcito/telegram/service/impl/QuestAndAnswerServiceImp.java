package com.bootcito.telegram.service.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bootcito.telegram.dto.request.SendMessageCoreQuestAnsw;
import com.bootcito.telegram.dto.response.ResponseBaseStatus;
import com.bootcito.telegram.service.QuestAndAnswerService;

@Service
public class QuestAndAnswerServiceImp implements QuestAndAnswerService {
	
	@Override
	public ResponseBaseStatus sendMessage(SendMessageCoreQuestAnsw sendMessageCoreQuestAnsw) {
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<SendMessageCoreQuestAnsw> request = new HttpEntity<>(sendMessageCoreQuestAnsw);
		
		ResponseEntity<ResponseBaseStatus> response = restTemplate
		  .exchange("http://localhost:8080/inputMessage", HttpMethod.POST, request, ResponseBaseStatus.class);
		
		return response.getBody();

		
	}

}
