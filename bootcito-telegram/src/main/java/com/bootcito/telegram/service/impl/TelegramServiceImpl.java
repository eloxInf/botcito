package com.bootcito.telegram.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.bootcito.telegram.constants.Response;
import com.bootcito.telegram.dto.response.Status;
import com.bootcito.telegram.service.TelegramService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TelegramServiceImpl extends TelegramLongPollingBot implements  TelegramService{
    
    private final Environment env;
    private final Logger log = LoggerFactory.getLogger(TelegramServiceImpl.class);


    @Override
    public void onUpdateReceived(Update update) {
        final String messageTextReceived = update.getMessage().getText();
        log.info("Mensaje: " + messageTextReceived);
        log.info("Destinatario: " + update.getMessage().getChatId());

    }

    @Override
    public String getBotUsername() {
        return env.getRequiredProperty("telegram-bot.user-name");
    }

    @Override
    public String getBotToken() {
        return env.getRequiredProperty("telegram-bot.token");
    }

    @Override
    public Status sendMessage(long chatId, String message){
         SendMessage sendMessage = new SendMessage();
         sendMessage.setChatId(chatId);
         sendMessage.setText(message);
 
         Status status = new Status();
         try {
             execute(sendMessage);
             status.setCode(Response.CODE_OK);
             status.setDescription(Response.STATUS_OK);

         } catch (TelegramApiException e) {
             log.error("[ERROR: TelegramServiceImpl - sendMessage]: {0}", e.getMessage());
             status.setCode(Response.CODE_NOK);
             status.setDescription(Response.STATUS_NOK_SEND_MESSAGE);
         }
         return status;
    }

}