package core.quest.answer.bot.mgr.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import core.quest.answer.bot.dto.RequestInputMessage;
import core.quest.answer.bot.dto.ResponseBase;
import core.quest.answer.bot.dto.ResponseInputMessage;
import core.quest.answer.bot.mgr.QuestionAndAnswerMgr;
import core.quest.answer.bot.model.QuestionAndAnswer;
import core.quest.answer.bot.service.QuestionsAndAnswersService;

@Component
public class QuestionAndAnswerMgrImp implements QuestionAndAnswerMgr {

	@Autowired
	private QuestionsAndAnswersService questionsAndAnswersService;

	final Logger log = LoggerFactory.getLogger(QuestionAndAnswerMgrImp.class);

	@Override
	public ResponseInputMessage getAnswer(RequestInputMessage requestInputMessage) {

		try {
			
			ResponseInputMessage reponse = questionsAndAnswersService
					.getQuestionAndAnswers(requestInputMessage.getMessage());
			
			return reponse;
			
			
		} catch (Exception e) {
			ResponseInputMessage reponse = new ResponseInputMessage();
			ResponseBase status =  new ResponseBase();
			
			status.setCode("418");
			status.setDesciption(e.getMessage());
			
			reponse.setStatus(status);	
			return reponse;

		}
	}
}
