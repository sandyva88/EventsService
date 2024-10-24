package com.activehub.eventsService.controllers;


import com.activehub.eventsService.models.events.requests.CreateEventRequest;
import com.activehub.eventsService.models.events.requests.GetPrincipalEventsRequest;
import com.activehub.eventsService.models.ws.WSResponse;
import com.activehub.eventsService.service.EventsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RequestMapping(value = "/events")
@RestController
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class EventsController {

    private EventsService eventsService;

    @PostMapping(value = "/create")
    public WSResponse createEvent(@RequestBody CreateEventRequest req){
        WSResponse wsResponse = new WSResponse();
        wsResponse.setRequestId(String.valueOf(UUID.randomUUID()));

        eventsService.createEvent(req);

        return wsResponse;
    }


    @PostMapping(value = "/getLast", consumes = "application/json", produces = "application/json")
    public WSResponse getLastEvents(@RequestBody GetPrincipalEventsRequest getPrincipalEventsRequest){
        WSResponse wsResponse = new WSResponse();
        wsResponse.setRequestId(String.valueOf(UUID.randomUUID()));
        wsResponse.setResponse(eventsService.getLastEvents(getPrincipalEventsRequest));
        return wsResponse;
    }

    @GetMapping(value = "/get/{id}")
    public WSResponse getLastEvents(@PathVariable("id") int id){
        WSResponse wsResponse = new WSResponse();
        wsResponse.setRequestId(String.valueOf(UUID.randomUUID()));
        wsResponse.setResponse(eventsService.getEvent(id));
        return wsResponse;
    }

    @GetMapping(value = "/findEvent/{title}")
    public WSResponse findEvent(@PathVariable("title") String title){
        WSResponse wsResponse = new WSResponse();
        wsResponse.setRequestId(String.valueOf(UUID.randomUUID()));
        wsResponse.setResponse(eventsService.findEvent(title));
        return wsResponse;
    }


}
