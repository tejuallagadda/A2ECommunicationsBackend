package com.a2e.collaboration.general.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by tejaswini.a on 02/05/20.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class A2eResponse {
    private long respCode;
    private long subRespCode;
    private String respMsg;
}
