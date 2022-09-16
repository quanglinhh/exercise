package com.example.rent.service;

import com.example.rent.model.Status;
import com.example.rent.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;

@Service
public class StatusServiceImpl implements StatusService{
    @Autowired
    StatusRepository statusRepository;
    @Override
    public Status findStatusById(Integer id) {
        Status status = statusRepository.findById(id).get();
        return status;
    }
}
