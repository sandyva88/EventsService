package com.activehub.eventsService.models.ws;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class WSResponse {

    private String status;
    private String requestId;
    private String id;
    private String date;
    private String hour;
    private Object response;
    private Error error;

}
