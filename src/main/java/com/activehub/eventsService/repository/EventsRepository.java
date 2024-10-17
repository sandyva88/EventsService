package com.activehub.eventsService.repository;

import com.activehub.eventsService.models.database.Category;
import com.activehub.eventsService.models.database.Events;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface EventsRepository extends JpaRepository<Events, Integer> {

    @Query("SELECT e.idEvent, e.title, SUBSTRING(e.content, 1, 180), e.imageUrl FROM Events e WHERE category = :category")
    Page<Events> findByCategoryMin(Pageable pageable, Category category);

    @Query("SELECT e.idEvent, e.title, SUBSTRING(e.content, 1, 180), e.imageUrl FROM Events e")
    Page<Events> findMin(Pageable pageable);


    @Query("SELECT e.idEvent, e.title, e.imageUrl FROM Events e Where e.title LIKE %:title%")
    List<Events> findByTitleMin(String title);
}
