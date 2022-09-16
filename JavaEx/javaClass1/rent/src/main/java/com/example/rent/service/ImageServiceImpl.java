package com.example.rent.service;

import com.example.rent.model.Images;
import com.example.rent.repository.ImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService{
    @Autowired
    ImagesRepository imagesRepository;

    @Override
    public List<Images> getImagesByRoomId(Long roomId) {
        List<Long> imageIds = imagesRepository.getImagesIdByRoomId(roomId);
        List<Images> imagesList = new ArrayList<>();
        imageIds.forEach(imageId->{
            Images image = imagesRepository.findById(imageId).get();
            imagesList.add(image);
        });
        return imagesList;
    }

    @Override
    public Images saveImage(Images image) {
        return imagesRepository.save(image);
    }
}
