package com.example.rent.service;

import com.example.rent.model.Room;
import com.example.rent.model.Status;
import com.example.rent.model.Users;
import com.example.rent.repository.RoomRepository;
import com.example.rent.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    StatusRepository statusRepository;
    @Autowired
    UserServiceImpl userService;

    @Override
    public List<Room> getAllRoom() {
        return roomRepository.findAll();
    }



    @Override
    public List<Room> getRoomsByUserId(Long uerId) {
        Users user = userService.getUserById(uerId).getBody();
        List<Room> rooms = roomRepository.findAllByUsersByUserId(user);
        return rooms;
    }


    @Override
    public ResponseEntity<Room> getRoomById(Long id) {
        if(roomRepository.findById(id).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Room room = roomRepository.findById(id).get();
        return ResponseEntity.ok(room);
    }

    @Override
    public ResponseEntity<Room> updateRoomById(Room room,Long id) {
        if(roomRepository.findById(id).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        room.setId(id);
        return ResponseEntity.ok(room);
    }

    @Override
    public ResponseEntity<Room> deleteRoomById(Long id) {
        Room room = roomRepository.findById(id).get();
        if(roomRepository.findById(id).isEmpty()){

        }
        roomRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public Room saveRoom(Room room) {
      return   roomRepository.save(room);
    }

    @Override
    public List<Room> findByTop3() {
        Page<Room> rooms = roomRepository.findByTopPrice(PageRequest.of(0, 3));
        List<Room> roomList = rooms.getContent();
        return roomList;
    }

    @Override
    public List<Room> findLastesRoom() {
        Page<Room> rooms = roomRepository.findLastestRoom(PageRequest.of(0, 4));
        List<Room> roomList = rooms.getContent();
        return roomList;
    }


}
