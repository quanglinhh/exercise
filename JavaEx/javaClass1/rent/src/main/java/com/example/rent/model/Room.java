package com.example.rent.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Room {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "area")
    private Double area;
    @Basic
    @Column(name = "price")
    private Double price;
//    @Basic
//    @Column(name = "status_id")
//    private Byte statusId;

    @Basic
    @Column(name = "post_content")
    private String postContent;
    @Basic
    @Column(name = "day_submited")
    @CreationTimestamp
    private Date daySubmited;
//    @Basic
//    @Column(name = "user_id")
//    private Long userId;
    @OneToMany(mappedBy = "roomByRoomId")
    private Collection<Contract> contractsById;
    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status statusByStatusId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users usersByUserId;

    @Basic
    @Column(name = "beds")
    private Integer beds;

    @Basic
    @Column(name = "baths")
    private Integer baths;
    @Basic
    @Column(name = "garage")
    private Integer garage;

    @JsonIgnore
    @OneToMany(mappedBy = "roomByRoomId")
    private Collection<RoomImage> roomImageById;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "room_image",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "image_id"))
    private List<Images> images = new ArrayList<>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

//    public Byte getStatusId() {
//        return statusId;
//    }
//
//    public void setStatusId(Byte statusId) {
//        this.statusId = statusId;
//    }



    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public Date getDaySubmited() {
        return daySubmited;
    }

    public void setDaySubmited(Date daySubmited) {
        this.daySubmited = daySubmited;
    }

//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return id == room.id && Objects.equals(address, room.address) && Objects.equals(area, room.area) && Objects.equals(price, room.price)  && Objects.equals(postContent, room.postContent) && Objects.equals(daySubmited, room.daySubmited) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, area, price, postContent, daySubmited);
    }

    public Collection<Contract> getContractsById() {
        return contractsById;
    }

    public void setContractsById(Collection<Contract> contractsById) {
        this.contractsById = contractsById;
    }

    public Status getStatusByStatusId() {
        return statusByStatusId;
    }

    public void setStatusByStatusId(Status statusByStatusId) {
        this.statusByStatusId = statusByStatusId;
    }

    public Users getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(Users usersByUserId) {
        this.usersByUserId = usersByUserId;
    }




    public Integer getBeds() {
        return beds;
    }

    public void setBeds(Integer beds) {
        this.beds = beds;
    }

    public Integer getBaths() {
        return baths;
    }

    public void setBaths(Integer baths) {
        this.baths = baths;
    }

    public Integer getGarage() {
        return garage;
    }

    public void setGarage(Integer garage) {
        this.garage = garage;
    }

    public Collection<RoomImage> getRoomImageById() {
        return roomImageById;
    }

    public void setRoomImageById(Collection<RoomImage> roomImageById) {
        this.roomImageById = roomImageById;
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }
}
