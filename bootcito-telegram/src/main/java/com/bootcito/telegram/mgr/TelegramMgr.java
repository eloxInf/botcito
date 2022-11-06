package com.bootcito.telegram.mgr;

import com.bootcito.telegram.dto.request.SendMessageRequest;
import com.bootcito.telegram.dto.response.SendMessageResponse;

public interface TelegramMgr {
    public SendMessageResponse sendMessage(SendMessageRequest sendMessageRequest);
}
