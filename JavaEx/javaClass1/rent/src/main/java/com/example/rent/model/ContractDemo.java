package com.example.rent.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "contract_demo", schema = "dbo", catalog = "rent")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class ContractDemo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "room_id")
    private Long roomId;
    @Basic
    @Column(name = "user_id")
    private Long userId;
    @Basic
    @Column(name = "ownder_id")
    private Long ownderId;
    @Basic
    @Column(name = "user_name")
    private String userName;
    @Basic
    @Column(name = "owner_name")
    private String ownerName;
    @Basic
    @Column(name = "room_address")
    private String roomAddress;
    @Basic
    @Column(name = "start_date")
    private Date startDate;
    @Basic
    @Column(name = "end_date")
    private Date endDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getPostId() {
        return roomId;
    }

    public void setPostId(Long postId) {
        this.roomId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOwnderId() {
        return ownderId;
    }

    public void setOwnderId(Long ownderId) {
        this.ownderId = ownderId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getRoomAddress() {
        return roomAddress;
    }

    public void setRoomAddress(String roomAddress) {
        this.roomAddress = roomAddress;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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
        ContractDemo that = (ContractDemo) o;
        return id == that.id && Objects.equals(roomId, that.roomId) && Objects.equals(userId, that.userId) && Objects.equals(ownderId, that.ownderId) && Objects.equals(userName, that.userName) && Objects.equals(ownerName, that.ownerName) && Objects.equals(roomAddress, that.roomAddress) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomId, userId, ownderId, userName, ownerName, roomAddress, startDate, endDate);
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
}
