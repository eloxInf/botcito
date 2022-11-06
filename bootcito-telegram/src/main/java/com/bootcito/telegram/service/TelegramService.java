package com.bootcito.telegram.service;

import com.bootcito.telegram.dto.response.ResponseBaseStatus;

public interface TelegramService {
    ResponseBaseStatus sendMessage(long chatId, String message);
}
