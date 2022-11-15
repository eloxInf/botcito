package core.quest.answer.bot.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import core.quest.answer.bot.dto.RequestInputMessage;
import core.quest.answer.bot.dto.ResponseBase;
import core.quest.answer.bot.dto.ResponseInputMessage;
import core.quest.answer.bot.dto.UserCommunicationDto;
import core.quest.answer.bot.model.UserCommunicationModel;
import core.quest.answer.bot.repository.UserCommunicationRepository;
import core.quest.answer.bot.service.UserCommunicationService;

@Service
public class UserComminicationServiceImp implements UserCommunicationService {

	@Autowired
	private UserCommunicationRepository userCommunicationRepository;

	@Override
	public ResponseBase saveCommunication(UserCommunicationDto requestInputMessage) {
		
		UserCommunicationModel userCom = new UserCommunicationModel();
		
		userCom.setIdentificationUser(requestInputMessage.getIdentificationUser());
		userCom.setMessage(requestInputMessage.getMessage());
		userCom.setSoruceMessage(requestInputMessage.getSoruceMessage());
		userCom.setPlatform(requestInputMessage.getPlatform());
		userCom.setIs_valid_answer(requestInputMessage.getIs_valid_answer());
		userCom.setIdParentMje(requestInputMessage.getIdParentMje());
		

		ResponseBase status = new ResponseBase();
		status.setCode("0");
		status.setDesciption("OK");

		ResponseInputMessage reponse = new ResponseInputMessage();
		reponse.setStatus(status);
		
		UserCommunicationModel reponseData = userCommunicationRepository.save(userCom);
		
		
		List<UserCommunicationModel> listUser = userCommunicationRepository.findAll();

		return status;

	}

}
