package core.quest.answer.bot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import core.quest.answer.bot.dto.RequestInputMessage;
import core.quest.answer.bot.mgr.QuestionAndAnswerMgr;

@RestController
public class comunicationController {
	
	final Logger log = LoggerFactory.getLogger(comunicationController.class);
	
	@Autowired
	private QuestionAndAnswerMgr questionAndAnswerMgr;
	
	
	
	@PostMapping(value= "/inputMessage")
	public String inputMessage(@RequestBody RequestInputMessage requestInputMessage) {
		
		return questionAndAnswerMgr.getAnswer(requestInputMessage);
		
	}

}
