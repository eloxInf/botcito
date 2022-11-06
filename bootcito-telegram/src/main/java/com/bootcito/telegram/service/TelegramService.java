package com.bootcito.telegram.service;

import com.bootcito.telegram.dto.response.Status;

public interface TelegramService {
    Status sendMessage(long chatId, String message);
}
