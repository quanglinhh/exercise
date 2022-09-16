package com.example.rent.controller.api;

import com.example.rent.model.Room;
import com.example.rent.repository.RoomRepository;
import com.example.rent.service.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController

@RequestMapping("/api/list/rooms")
public class RoomController {
    @Autowired
    RoomServiceImpl roomService;
    @Autowired
    RoomRepository roomRepository;

    @GetMapping()
    public List<Room> getAllRoom() {
        return roomService.getAllRoom();
    }
    @GetMapping("/user/{userId}")
    public List<Room> getAllRoomByUserId(@PathVariable("userId") long userId){

        List<Room> rooms = roomService.getRoomsByUserId(userId);

        return rooms;
    }

    @GetMapping("/top3")
    public List<Room> getTop3(){
        return roomService.findByTop3();
    }

    @GetMapping("/top4lastest")
    public List<Room> get4LastTest(){
        return roomService.findLastesRoom();
    }

}
