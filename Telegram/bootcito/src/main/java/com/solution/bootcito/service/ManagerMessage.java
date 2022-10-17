package com.solution.bootcito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerMessage {
    @Autowired
    TelegramBoot telegramBoot = new TelegramBoot();
    ComparePriceBoot comparePriceBoot = new ComparePriceBoot();

    boolean executeBoot = false;
    String url = "https://sodimac.falabella.com/sodimac-cl/product/110004639/Led-40-mgs4008x-FullHD-Smart-TV/110004645";
    int price = 0;
    public void readMessage(String messageTextReceived,long chatId){
           // Se crea un objeto mensaje
        String msg = messageHomologator(messageTextReceived);
        if (!msg.isEmpty()) {
          telegramBoot.sendMessage(chatId, msg);
        }
        if (executeBoot){
            try {
                msg = comparePriceBoot.executeBoot(url, price);
                telegramBoot.sendMessage(chatId, msg);
            
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String messageHomologator(String messageTextReceived){
        String msg = "";
        if (messageTextReceived.toLowerCase().equals("Hola".toLowerCase())){
            msg = "¡Bienvenido a botcito!\n envianos tu link del producto ";
        }
        if (messageTextReceived.contains("falabella")){
            url = messageTextReceived;
            msg = "A que valor quieres comprar el producto?";
        }
        if (messageTextReceived.contains("$")){
            msg = "Te avisaremos cuando este al valor " + messageTextReceived;
            price = Integer.parseInt(messageTextReceived.replace("$", ""));
            executeBoot = true;
        }
        return msg;
    }
}
