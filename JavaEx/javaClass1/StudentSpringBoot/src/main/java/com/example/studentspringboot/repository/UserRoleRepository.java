package com.example.studentspringboot.repository;

import com.example.studentspringboot.model.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoles,Long> {

    List<UserRoles> findAllByRoleId(Integer roleId);

}
