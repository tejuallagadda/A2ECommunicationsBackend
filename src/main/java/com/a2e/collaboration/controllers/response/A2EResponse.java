package com.a2e.collaboration.controllers.response;

import com.a2e.collaboration.controllers.response.commons.A2EHeader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by tejaswini.a on 02/05/20.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class A2EResponse {
    private A2EHeader a2EHeader;

}
