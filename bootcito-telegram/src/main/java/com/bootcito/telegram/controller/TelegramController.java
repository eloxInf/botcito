package com.bootcito.telegram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcito.telegram.constants.Url;
import com.bootcito.telegram.dto.request.SendMessageRequest;
import com.bootcito.telegram.dto.response.SendMessageResponse;
import com.bootcito.telegram.mgr.TelegramMgr;

@RequestMapping(value = Url.URL_BASE)
@RestController
public class TelegramController {
    @Autowired
    private TelegramMgr telegramMgr;

    @PostMapping(value = Url.URL_SEND_MESSAGE)
    public ResponseEntity<SendMessageResponse> sendMessage(@RequestBody SendMessageRequest sendMessageRequest){
        return new ResponseEntity<>(telegramMgr.sendMessage(sendMessageRequest), HttpStatus.OK);
    }
}
