package com.activehub.eventsService.models.events.requests;


import lombok.Data;

@Data
public class CreateEventRequest {

    private String title;
    private String content;
    private String category;
    private String address;
    private Double pricePerson;
    private String imageUrl;
    private int minParticipants;
    private int maxParticipants;
}
