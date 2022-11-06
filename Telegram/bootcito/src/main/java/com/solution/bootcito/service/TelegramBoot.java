package com.solution.bootcito.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class TelegramBoot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        // Se obtiene el mensaje escrito por el usuario
        final String messageTextReceived = update.getMessage().getText();

        System.out.println("Escribieron en el bot " + messageTextReceived);

        // Se obtiene el id de chat del usuario
        final long chatId = update.getMessage().getChatId();

        ManagerMessage managerMessage = new ManagerMessage();
        
        managerMessage.readMessage(messageTextReceived, chatId);

    }


    @Override
    public String getBotUsername() {
        return "new_cito_bot";
    }

    @Override
    public String getBotToken() {
        return "5432507808:AAEdpTH6z2ngihc4k2Mllchfu1TTSxOSGnY";
    }

    public void sendMessage(long chatId, String msg){
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(msg);
        try {
            // Se envía el mensaje
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
 

}
