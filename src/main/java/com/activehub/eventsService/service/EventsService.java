package com.activehub.eventsService.service;


import com.activehub.eventsService.models.database.Category;
import com.activehub.eventsService.models.database.Events;
import com.activehub.eventsService.models.events.requests.CreateEventRequest;
import com.activehub.eventsService.models.events.requests.GetPrincipalEventsRequest;
import com.activehub.eventsService.repository.CategoryRepository;
import com.activehub.eventsService.repository.EventsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class EventsService {

    private EventsRepository eventsRepository;
    private CategoryRepository categoryRepository;

    public Events createEvent(CreateEventRequest req){
        Events event = new Events();
        event.setTitle(req.getTitle());
        event.setContent(req.getContent());
        eventsRepository.save(event);
        return event;
    }

    public Page<Events> getLastEvents(GetPrincipalEventsRequest getPrincipalEventsRequest){

        Sort.Direction direction = getPrincipalEventsRequest.getOrderDesc() ? Sort.Direction.DESC : Sort.Direction.ASC;
        Sort sort = Sort.by(direction, "idEvent");
        Pageable pageable = PageRequest.of(getPrincipalEventsRequest.getPage(), getPrincipalEventsRequest.getItems(), sort);

        Category category = categoryRepository.findByName(getPrincipalEventsRequest.getCategory());

        Page<Events> listEvents;
        if (category != null){
           listEvents = eventsRepository.findByCategoryMin(pageable, category);
        }
        else{
            listEvents = eventsRepository.findMin(pageable);
        }


        if (!listEvents.isEmpty())
            return listEvents;
        return null;
    }

    public Optional<Events> getEvent(int id){
        Optional<Events> event = eventsRepository.findById(id);
        if (event.isPresent()){
            return event;
        } else {
            log.info("No se encontro el evento");
            return Optional.empty();
        }
    }

    public List<Events> findEvent(String title){
        List<Events> events = eventsRepository.findByTitleMin(title);
        if (!events.isEmpty()){
            return events;
        } else {
            log.info("No se encontro el evento");
            return events;
        }
    }
}
