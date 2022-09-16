package com.example.rent.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name = "room_image", schema = "dbo", catalog = "rent")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class RoomImage {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room roomByRoomId;
    @ManyToOne(cascade = {CascadeType.MERGE})

    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Images imageByImageId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Room getRoomByRoomId() {
        return roomByRoomId;
    }

    public void setRoomByRoomId(Room roomByRoomId) {
        this.roomByRoomId = roomByRoomId;
    }

    public Images getImageByImageId() {
        return imageByImageId;
    }

    public void setImageByImageId(Images imageByImageId) {
        this.imageByImageId = imageByImageId;
    }
}
