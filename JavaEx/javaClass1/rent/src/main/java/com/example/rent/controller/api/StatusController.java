package com.example.rent.controller.api;

import com.example.rent.model.Status;
import com.example.rent.service.StatusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
    @Autowired
    StatusServiceImpl statusService;
    @GetMapping("/api/status/{id}")
    Status getStatusById(@PathVariable("id")
            Integer id){
      return   statusService.findStatusById(id);
    }
}
