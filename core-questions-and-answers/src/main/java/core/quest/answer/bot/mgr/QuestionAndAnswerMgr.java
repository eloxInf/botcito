package core.quest.answer.bot.mgr;

import core.quest.answer.bot.dto.RequestInputMessage;
import core.quest.answer.bot.dto.ResponseInputMessage;

public interface QuestionAndAnswerMgr {

	ResponseInputMessage getAnswer(RequestInputMessage requestInputMessage);

}
