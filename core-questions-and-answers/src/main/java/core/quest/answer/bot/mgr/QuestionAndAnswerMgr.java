package core.quest.answer.bot.mgr;

import core.quest.answer.bot.dto.RequestInputMessage;

public interface QuestionAndAnswerMgr {

	String getAnswer(RequestInputMessage requestInputMessage);

}
