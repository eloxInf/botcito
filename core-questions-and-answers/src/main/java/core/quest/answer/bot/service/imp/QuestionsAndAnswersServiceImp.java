package core.quest.answer.bot.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.quest.answer.bot.model.QuestionAndAnswer;
import core.quest.answer.bot.repository.QuestionAndAnswerRepository;
import core.quest.answer.bot.service.QuestionsAndAnswersService;

@Service
public class QuestionsAndAnswersServiceImp implements QuestionsAndAnswersService {

	@Autowired
	private QuestionAndAnswerRepository questionAndAnswerRepository;
	
	@Override
	public QuestionAndAnswer getQuestionAndAnswers(String userMessage) {
		
		return questionAndAnswerRepository.findByUserMessage(userMessage);
	}
}
