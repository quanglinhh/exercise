package com.example.rent.service;

import com.example.rent.model.RoomImage;
import com.example.rent.repository.RoomImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomImageServiceImpl implements RoomImageService{
    @Autowired
    RoomImageRepository roomImageRepository;

    @Override
    public RoomImage saveRoomImage(RoomImage roomImage) {

        return roomImageRepository.save(roomImage);
    }
}
