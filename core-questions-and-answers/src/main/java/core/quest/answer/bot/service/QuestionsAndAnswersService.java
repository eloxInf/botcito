package core.quest.answer.bot.service;


import core.quest.answer.bot.dto.ResponseInputMessage;

public interface QuestionsAndAnswersService {

	ResponseInputMessage getQuestionAndAnswers(String userMessage);

	ResponseInputMessage getInternalAnswer(String codInternal);

}
