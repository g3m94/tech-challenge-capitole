package com.tech.capitole.challenge.model;

import java.time.LocalDateTime;

import static com.tech.capitole.challenge.util.Constants.STRING_RESPONSE_MESSAGE_SUCCESSFUL;
import static com.tech.capitole.challenge.util.Utils.formatterOutput;

public record SuccessResponse<T>(
        String message,
        T data,
        String date
) {
    public SuccessResponse(T data) {
        this(STRING_RESPONSE_MESSAGE_SUCCESSFUL, data, LocalDateTime.now().format(formatterOutput));
    }
}
