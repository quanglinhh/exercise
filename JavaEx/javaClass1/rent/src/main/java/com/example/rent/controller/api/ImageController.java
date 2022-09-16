package com.example.rent.controller.api;

import com.example.rent.model.Images;
import com.example.rent.service.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/image")
public class ImageController {
    @Autowired
    ImageServiceImpl imageService;

    @GetMapping("/{roomId}")
    List<Images> etImageByRoomId(@PathVariable("roomId") Long id){
        return imageService.getImagesByRoomId(id);
    }
}
