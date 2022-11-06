package core.quest.answer.bot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import core.quest.answer.bot.dto.RequestInputMessage;
import core.quest.answer.bot.dto.ResponseInputMessage;
import core.quest.answer.bot.mgr.QuestionAndAnswerMgr;

@RestController
public class comunicationController {
	
	final Logger log = LoggerFactory.getLogger(comunicationController.class);
	
	@Autowired
	private QuestionAndAnswerMgr questionAndAnswerMgr;
	
	
	
	@PostMapping(value= "/inputMessage")
	public ResponseEntity<ResponseInputMessage> inputMessage(@RequestBody RequestInputMessage requestInputMessage) {

		ResponseInputMessage response = questionAndAnswerMgr.getAnswer(requestInputMessage);
		return new ResponseEntity<ResponseInputMessage>(response, HttpStatus.OK);
	
	}

}
