package com.a2e.collaboration.controllers.request;

import com.a2e.collaboration.controllers.request.commons.CallerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by tejaswini.a on 02/05/20.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class A2ERequest {
    private CallerInfo callerInfo;
}
