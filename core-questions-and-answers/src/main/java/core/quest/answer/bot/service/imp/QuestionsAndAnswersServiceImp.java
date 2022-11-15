package core.quest.answer.bot.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.quest.answer.bot.dto.ResponseBase;
import core.quest.answer.bot.dto.ResponseInputMessage;
import core.quest.answer.bot.model.QuestionAndAnswerModel;
import core.quest.answer.bot.repository.QuestionAndAnswerRepository;
import core.quest.answer.bot.service.QuestionsAndAnswersService;

@Service
public class QuestionsAndAnswersServiceImp implements QuestionsAndAnswersService {

	@Autowired
	private QuestionAndAnswerRepository questionAndAnswerRepository;

	@Override
	public ResponseInputMessage getQuestionAndAnswers(String userMessage) {

		ResponseBase status = new ResponseBase();
		status.setCode("0");
		status.setDesciption("OK");

		ResponseInputMessage reponse = new ResponseInputMessage();
		reponse.setStatus(status);
		List<QuestionAndAnswerModel> reponseData = questionAndAnswerRepository.findByUserMessage(userMessage);

		QuestionAndAnswerModel uniqueResul = new QuestionAndAnswerModel();
		if (reponseData.size() > 0) {
			uniqueResul = reponseData.get(0);
		}

		reponse.setMessage(uniqueResul.getBotMessage());

		return reponse;

	}

	@Override
	public ResponseInputMessage getInternalAnswer(String codInternal) {

		ResponseBase status = new ResponseBase();
		status.setCode("0");
		status.setDesciption("OK");

		ResponseInputMessage reponse = new ResponseInputMessage();
		
		List<QuestionAndAnswerModel> reponseData = questionAndAnswerRepository.findByInternalCode(codInternal);

		QuestionAndAnswerModel uniqueResul = new QuestionAndAnswerModel();
		if (reponseData.size() > 0) {
			uniqueResul = reponseData.get(0);
		}
		
		reponse.setMessage(uniqueResul.getBotMessage());

		return reponse;

	}
}
