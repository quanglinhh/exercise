package com.example.rent.controller.view;

import com.example.rent.model.*;
import com.example.rent.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ContractDemoControllerView {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    ContractDemoServiceImpl contractDemoService;

    @Autowired
    StatusServiceImpl statusService;
    @Autowired
    RoomServiceImpl roomService;

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

    @PostMapping("/saveContractDemo")
    public String saveContractDemo(@ModelAttribute ContractDemo contractDemo){
        Long id = getcurrentUserId();
        Room room =roomService.getRoomById(contractDemo.getRoomId()).getBody();
        //if room status == empty => thue duoc nha
        Status currentStatus = statusService.findStatusById(1);
        if(room.getStatusByStatusId()==currentStatus){
            Status status = statusService.findStatusById(2);
            room.setStatusByStatusId(status);
            roomService.saveRoom(room);
            contractDemoService.saveContractDemo(contractDemo);
        }
        return "redirect:/list/contractDemo/user/"+id;
    }

    @GetMapping("/list/contractDemo/user/{ownerId}")
    public String getContractDemo(@PathVariable("ownerId") Long ownerId, Model model){
        List<ContractDemo> contractDemos = contractDemoService.findAllByOwnderId(ownerId);
        model.addAttribute("contractDemos",contractDemos);
        Long currentUserId = getcurrentUserId();
        model.addAttribute("currentUserId",currentUserId);
        return "contract/contractDemos";
    }

    @GetMapping ("/deleteConTractDemo")
    public String deleteContractDemo(@RequestParam Long contractDemoId){
        contractDemoService.deleteContractDemo(contractDemoId);
        Long userId = getcurrentUserId();
        return "redirect:/list/contractDemo/user/"+userId;

    }


}
