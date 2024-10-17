package com.activehub.eventsService.repository;

import com.activehub.eventsService.models.database.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category findByName(String name);
}
