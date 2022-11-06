package com.bootcito.telegram.dto.request;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Valid
public class SendMessageRequest {
    /**
     * chatId
     */
    @NotEmpty
    @NotNull
    private String chatId;
    /**
     * message
     */
    @NotEmpty
    @NotNull
    private String message;
}
