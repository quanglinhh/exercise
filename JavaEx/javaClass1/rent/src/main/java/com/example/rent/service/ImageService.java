package com.example.rent.service;

import com.example.rent.model.Images;

import java.util.HashSet;
import java.util.List;

public interface ImageService {
    List<Images> getImagesByRoomId(Long roomId);

    Images saveImage(Images image);


}
