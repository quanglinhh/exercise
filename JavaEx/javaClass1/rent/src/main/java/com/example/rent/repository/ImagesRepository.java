package com.example.rent.repository;

import com.example.rent.model.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagesRepository extends JpaRepository<Images,Long> {
    @Query(value = "select i.id from Images i inner join\n" +
            "RoomImage ri on ri.imageByImageId.id = i.id inner join\n" +
            "Room r on ri.roomByRoomId.id = r.id where r.id = ?1")
    List<Long> getImagesIdByRoomId(Long roomId);


}
