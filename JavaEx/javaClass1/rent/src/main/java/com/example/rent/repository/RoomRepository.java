package com.example.rent.repository;

import com.example.rent.model.Room;
import com.example.rent.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {
    List<Room> findAllByUsersByUserId(Users users);

    @Query(value = "SELECT r FROM Room r ORDER BY r.price DESC")
    Page<Room> findByTopPrice(PageRequest of);
    @Query(value = "SELECT r FROM Room r order by r.daySubmited DESC ")
    Page<Room> findLastestRoom(PageRequest of);
}
