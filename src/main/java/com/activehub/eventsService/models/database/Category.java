package com.activehub.eventsService.models.database;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "events_category", schema = "active_hub")
public class Category {
    @Id
    @Column(name = "id_category")
    private int idCategory;
    @Column(name = "name")
    private String name;
    @Column(name = "icon")
    private String icon;
    @Column(name = "creation_date")
    private Date creationDate;
    @Column(name = "edit_date")
    private Date editDate;
    @Column(name = "status")
    private Boolean status;
}
