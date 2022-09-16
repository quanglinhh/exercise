package com.example.rent.service;

import com.example.rent.model.Room;
import com.example.rent.model.Status;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    List<Room> getAllRoom();
    List<Room> getRoomsByUserId(Long id);
    ResponseEntity<Room> getRoomById(Long userId);

    ResponseEntity<Room> updateRoomById(Room room,Long id);

    ResponseEntity<Room> deleteRoomById(Long id);
   Room saveRoom(Room room);
   List<Room> findByTop3();
   List<Room> findLastesRoom();
}
