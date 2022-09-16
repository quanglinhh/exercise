package com.example.rent.controller.view;

import com.example.rent.model.*;
import com.example.rent.repository.UserRepository;
import com.example.rent.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

@Controller
public class RoomControllerView {
    private final String UPLOAD_DIR = "src/main/resources/static/uploads/";
    @Autowired
    RoomServiceImpl roomService;
    @Autowired
    StatusServiceImpl statusService;
    @Autowired
   UserServiceImpl userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ImageServiceImpl imageService;
    @Autowired
    RoomImageServiceImpl roomImageService;

    public Long getcurrentUserId(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();

        } else {
            username = principal.toString();
        }
        Optional<Users> opUsert = userService.findByUserName(username);
        Users u;
        if(opUsert.isPresent()) {
            u = opUsert.get();
        } else {
            u = new Users();
        }
        Long currentUserId = u.getId();
        return currentUserId;
    }

    public void GetId(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();

        } else {
            username = principal.toString();
        }
        Optional<Users> opUsert = userService.findByUserName(username);
        Users u;
        if(opUsert.isPresent()) {
            u = opUsert.get();
        } else {
            u = new Users();
        }
        model.addAttribute("currentUserId",u.getId());
        model.addAttribute("name", u.getFullname());

        System.out.println(u.getId());
    }

    @GetMapping("/list/rooms/user/{userId}")
    public String listRoom( Model model, @PathVariable("userId")Long userId){
        Users user = userRepository.findById(userId).get();
        model.addAttribute("user",user);
        GetId(model);
        List<Room> rooms = roomService.getRoomsByUserId(userId);
        model.addAttribute("rooms",rooms);

        return "rooms/rooms";
    }

    @GetMapping("/addRoom/user/{userId}")
    public String addRoom(Model model, @PathVariable("userId") Long userId){
        Room room = new Room();
//        Users u = userService.getUserById(userId).getBody();
//        room.setUsersByUserId(u);
        model.addAttribute("room",room);
        GetId(model);
        return "rooms/addRoomForm";
    }
    @Transactional
    @PostMapping("/saveRoom")
    public String saveRoom(@ModelAttribute Room room,@RequestParam MultipartFile file){
        Users u = userService.getUserById(getcurrentUserId()).getBody();
        room.setUsersByUserId(u);
        Status status = statusService.findStatusById(1);
        room.setStatusByStatusId(status);
        roomService.saveRoom(room);
        if (file.isEmpty()) {
        }
        // normalize the file path
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        // save the file on the local file system
        try {
            Path path = Paths.get(UPLOAD_DIR);
            //String avatar = path.toString();
            List<Images> images = new ArrayList<>();
            Images image = new Images();
            image.setName(fileName);
            imageService.saveImage(image);
            images.add(image);
            room.setImages(images);
            Collection<RoomImage> roomImages = new ArrayList<>();
            images.forEach(i->{
                RoomImage roomImage = new RoomImage();
                roomImage.setRoomByRoomId(room);
                roomImage.setImageByImageId(i);
                roomImageService.saveRoomImage(roomImage);
                roomImages.add(roomImage);
            });

            Files.copy(file.getInputStream(), path.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        return "redirect:/list/rooms/user/"+getcurrentUserId();
        return "redirect:/list/room";
    }


    @GetMapping("/deleteRoom")
    public String deleteRoom(@RequestParam Long roomId){
        roomService.deleteRoomById(roomId);
        return "redirect:/list/rooms/user"+getcurrentUserId();
    }

    @GetMapping("/list/room")
    public String getAllRoom(Model model){
        List<Room> rooms = roomService.getAllRoom();
        model.addAttribute("rooms",rooms);
        Long id = getcurrentUserId();
        model.addAttribute("currentUserId",id);
        Users currentUser = userRepository.findById(id).get();
        model.addAttribute("currentUser",currentUser);
        return "homes/property-grid";
    }

    @GetMapping("/roomDetails")
    public String roomDetails(Model model,@RequestParam Long roomId){
        Room room = roomService.getRoomById(roomId).getBody();
        model.addAttribute("room",room);
        Long currentUserId = getcurrentUserId();
        model.addAttribute("currentUserId",currentUserId);
        List<Images> images = imageService.getImagesByRoomId(roomId);
        model.addAttribute("imageList",images);
        Long id = getcurrentUserId();
        Users currentUser = userRepository.findById(id).get();
        model.addAttribute("currentUser",currentUser);
        return "homes/property-single";
    }
}
