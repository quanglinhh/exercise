package com.example.rent.controller.view;

import com.example.rent.model.*;
import com.example.rent.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ContractControllerView {
    @Autowired
    ContractServiceImpl contractService;
    @Autowired
    UserServiceImpl userService;

    @Autowired
    ContractDemoServiceImpl contractDemoService;
    @Autowired
    StatusServiceImpl statusService;
    @Autowired
    RoomServiceImpl roomService;

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

    @GetMapping("/addContract/user/{userId}")
    public String addContract(Model model, @PathVariable("userId")Long userId, @RequestParam Long roomId){
        Users user = userService.getUserById(userId).getBody();
        model.addAttribute("user",user);
        Room room = roomService.getRoomById(roomId).getBody();
        model.addAttribute("room",room);
        Long id = getcurrentUserId();
        model.addAttribute("currentUserId",id);
        return "contract/editContract";
    }

    @GetMapping("/saveContract")
    public String saveContract(@RequestParam Long contractDemoId){
      ContractDemo contractDemo = contractDemoService.findById(contractDemoId);
      Long id = contractDemo.getOwnderId();
      Users user = userService.getUserById(contractDemo.getUserId()).getBody();

      Room room = roomService.getRoomById(contractDemo.getRoomId()).getBody();
      Status status = statusService.findStatusById(3);
      room.setStatusByStatusId(status);
      roomService.saveRoom(room);
      Contract contract = new Contract();
      contract.setUsersByUserId(user);
      contract.setStartDate(contractDemo.getStartDate());
      contract.setEndDate(contractDemo.getEndDate());
      contract.setRoomByRoomId(room);
      contractDemoService.deleteContractDemo(contractDemoId);
      contractService.saveContract(contract);

      return "redirect:/list/contract/user/"+id;
    }

    @GetMapping("/list/contract/user/{userId}")
    public String listContract(Model model, @PathVariable("userId")Long id){
        List<Contract> contractsByUser = contractService.getAllByUserId(id);
        List<Contract> contractsByOwner = contractService.getAllByOwnerId(id);
        List<Contract> contracts = new ArrayList<>();
        contracts.addAll(contractsByUser);
        contracts.addAll(contractsByOwner);
        model.addAttribute("contracts", contracts);
        Long currentUserId = getcurrentUserId();
        model.addAttribute("currentUserId",currentUserId);
        return "contract/contracts";
    }

}
