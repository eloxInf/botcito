package com.bootcito.telegram.mgr.impl;

import org.springframework.stereotype.Component;

import com.bootcito.telegram.constants.Response;
import com.bootcito.telegram.dto.request.SendMessageRequest;
import com.bootcito.telegram.dto.response.SendMessageResponse;
import com.bootcito.telegram.dto.response.Status;
import com.bootcito.telegram.mgr.TelegramMgr;
import com.bootcito.telegram.service.TelegramService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TelegramMgrImpl implements TelegramMgr{

    private TelegramService telegramService;

    @Override
    public SendMessageResponse sendMessage(SendMessageRequest sendMessageRequest){
        
        Status status = new Status();
        
        final long chatId = Long.parseLong(sendMessageRequest.getChatId());
        
        status = telegramService.sendMessage(chatId, sendMessageRequest.getMessage());
            
        SendMessageResponse sendMessageResponse = new SendMessageResponse();
        sendMessageResponse.setStatus(status);
        return sendMessageResponse;
        
    }

}
