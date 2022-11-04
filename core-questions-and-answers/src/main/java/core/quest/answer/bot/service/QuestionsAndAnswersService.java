package core.quest.answer.bot.service;


import core.quest.answer.bot.model.QuestionAndAnswer;

public interface QuestionsAndAnswersService {

	QuestionAndAnswer getQuestionAndAnswers(String userMessage);

}
