package com.example.rent.repository;

import com.example.rent.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract,Long> {
    @Query(value = "select c.id from Contract c inner join Users u on u.id = c.usersByUserId.id where u.id=?1")
    List<Long> getContactIdByUserId(Long userId);
    @Query(value = "select c.id from Contract c inner join Room r on c.roomByRoomId.id = r.id where r.usersByUserId.id = ?1")
    List<Long> getContactIdByOwnerId(Long ownerId);

    @Query(value= "SELECT COUNT (c.id) FROM Contract c inner join Room r on c.roomByRoomId.id=r.id where r.usersByUserId.id =?1")
    Long getAmountContractByUser(Long ownerId);

}
