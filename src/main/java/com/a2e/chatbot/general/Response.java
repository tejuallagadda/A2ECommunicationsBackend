package com.a2e.chatbot.general;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by tejaswini.a on 26/04/20.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class Response {
    private Integer respCode;
    private String respMessage;
}
