package core.quest.answer.bot.mgr.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import core.quest.answer.bot.dto.RequestInputMessage;
import core.quest.answer.bot.dto.ResponseBase;
import core.quest.answer.bot.dto.ResponseInputMessage;
import core.quest.answer.bot.dto.TelegramRequestSendMessage;
import core.quest.answer.bot.dto.UserCommunicationDto;
import core.quest.answer.bot.mgr.QuestionAndAnswerMgr;
import core.quest.answer.bot.model.QuestionAndAnswerModel;
import core.quest.answer.bot.service.QuestionsAndAnswersService;
import core.quest.answer.bot.service.TelegramService;
import core.quest.answer.bot.service.UserCommunicationService;

@Component
public class QuestionAndAnswerMgrImp implements QuestionAndAnswerMgr {

	@Autowired
	private QuestionsAndAnswersService questionsAndAnswersService;
	
	@Autowired
	private UserCommunicationService userCommunicationService;
	
	
	@Autowired
	private TelegramService telegramService;

	final Logger log = LoggerFactory.getLogger(QuestionAndAnswerMgrImp.class);

	@Override
	public ResponseInputMessage getAnswer(RequestInputMessage requestInputMessage) {

		try {
			UserCommunicationDto userCommincation = new UserCommunicationDto();
			
			userCommincation.setMessage(requestInputMessage.getMessage());
			userCommincation.setIdentificationUser(requestInputMessage.getIdentificationUser());
			userCommincation.setIdParentMje("");
			userCommincation.setSoruceMessage(requestInputMessage.getPlatform());
			userCommincation.setIdentificationUser(requestInputMessage.getIdentificationUser());
			
			userCommunicationService.saveCommunication(userCommincation);
			
			ResponseInputMessage reponse = questionsAndAnswersService
					.getQuestionAndAnswers(requestInputMessage.getMessage().trim().toLowerCase());
			
			// Flujo para URL
			if(containUrl(requestInputMessage.getMessage())) {
				
				ResponseInputMessage internalMessage = questionsAndAnswersService
						.getInternalAnswer("5");
				
				reponse.setMessage(internalMessage.getMessage());
			}
						
			if(reponse.getMessage() == null) {
				reponse.setMessage("Aun no se responder esa pregunta :/");
			}
			
			if(requestInputMessage.getMessage().trim().toLowerCase().equals("/salud")) {
				
				TelegramRequestSendMessage telegramRequestSendMessage = new TelegramRequestSendMessage();
				
				telegramRequestSendMessage.setChatId(requestInputMessage.getIdentificationUser());
				telegramRequestSendMessage.setMessage("Servicio Telegram -> ok");
				
				telegramService.sendMessage(telegramRequestSendMessage);
				telegramRequestSendMessage.setMessage("bot de respuestas -> ok");
				
				telegramService.sendMessage(telegramRequestSendMessage);
				telegramRequestSendMessage.setMessage("bot de busqueda -> ok");
				
				
				telegramService.sendMessage(telegramRequestSendMessage);
				telegramRequestSendMessage.setMessage("Botcito esta vivo y coleando.. Adios!");
				
				telegramService.sendMessage(telegramRequestSendMessage);
				
				reponse.setMessage("");
				return reponse;
			}
			
			TelegramRequestSendMessage telegramRequestSendMessage = new TelegramRequestSendMessage();
			
			telegramRequestSendMessage.setChatId(requestInputMessage.getIdentificationUser());
			telegramRequestSendMessage.setMessage(reponse.getMessage());
			
			telegramService.sendMessage(telegramRequestSendMessage);
			
			
			return reponse;
			
			
		} catch (Exception e) {
			
			log.error(e.getMessage());
			ResponseInputMessage reponse = new ResponseInputMessage();
			ResponseBase status =  new ResponseBase();
			
			status.setCode("418");
			status.setDesciption(e.getMessage());
			
			reponse.setStatus(status);	
			return reponse;

		}
	}
	
	private Boolean containUrl(String message) {
		
		return (message.contains("https"));

		
	}
	
	
	
	
}
