package com.activehub.eventsService.models.events.requests;

import lombok.Data;

@Data
public class GetPrincipalEventsRequest {
    private String category;
    private int page;
    private int items;
    private Boolean orderDesc;
}
