package com.activehub.eventsService.models.database;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "events")
public class Events {
    @Id
    @Column(name = "id_event")
    private int idEvent;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "id_category", foreignKey = @ForeignKey(name = "events_category_fkey"))
    private Category category;
    @Column(name = "address")
    private String address;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "id_price_catalog")
    private String priceCatalog;
    @Column(name = "price_person")
    private Double pricePerson;
    @Column(name = "organizer_id")
    private String organizerId;
    @Column(name = "creation_date")
    private Date creationDate;
    @Column(name = "edit_date")
    private Date editDate;
    @Column(name = "status")
    private Boolean status;
}
