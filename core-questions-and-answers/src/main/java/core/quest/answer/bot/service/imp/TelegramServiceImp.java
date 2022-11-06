package core.quest.answer.bot.service.imp;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import core.quest.answer.bot.dto.ResponseBase;
import core.quest.answer.bot.dto.TelegramRequestSendMessage;
import core.quest.answer.bot.service.TelegramService;

@Service
public class TelegramServiceImp implements TelegramService {
	
	
	@Override
	public
	ResponseBase sendMessage(TelegramRequestSendMessage telegramRequestSendMessage) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<TelegramRequestSendMessage> request = new HttpEntity<>(telegramRequestSendMessage);
		
		ResponseEntity<ResponseBase> response = restTemplate
		  .exchange("http://localhost:9090/bootcito/telegram/sendMessage", HttpMethod.POST, request, ResponseBase.class);
		
		return response.getBody();
		
	}

}
