package com.example.rent.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Contract {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
//    @Basic
//    @Column(name = "user_id")
//    private Long userId;
//    @Basic
//    @Column(name = "room_id")
//    private Long roomId;
    @Basic
    @Column(name = "start_date")
    private Date startDate;
    @Basic
    @Column(name = "month")
    private Integer month;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "end_date")
    private Date endDate;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users usersByUserId;
    @ManyToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room roomByRoomId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
//
//    public Long getRoomId() {
//        return roomId;
//    }
//
//    public void setRoomId(Long roomId) {
//        this.roomId = roomId;
//    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return id == contract.id  && Objects.equals(startDate, contract.startDate) && Objects.equals(month, contract.month) && Objects.equals(status, contract.status) && Objects.equals(endDate, contract.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, month, status, endDate);
    }

    public Users getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(Users usersByUserId) {
        this.usersByUserId = usersByUserId;
    }

    public Room getRoomByRoomId() {
        return roomByRoomId;
    }

    public void setRoomByRoomId(Room roomByRoomId) {
        this.roomByRoomId = roomByRoomId;
    }
}
