package com.example.springboot.controller;

import com.example.springboot.controller.dto.ListUser;
import com.example.springboot.model.TblUser;
import com.example.springboot.service.TblUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TblUserController {
    @Autowired
    TblUserService tblUserService;
    //
    @RequestMapping(value="/User",method = RequestMethod.GET)
    public ResponseEntity<List<TblUser>> listAllUser(){
        List<TblUser> listUser = tblUserService.getAllUser();

        if(listUser.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<TblUser>>(listUser,HttpStatus.OK);
    }
    @RequestMapping(value = "/User/{id}",method = RequestMethod.GET)
    public ResponseEntity<TblUser> getUserById(@PathVariable("id") Long id){
        TblUser u = tblUserService.getOne(id);
        return new ResponseEntity<TblUser>(u,HttpStatus.OK);
    }
    @RequestMapping(value = "/User",method = RequestMethod.POST)
    public ResponseEntity<TblUser> saveUser(@RequestBody TblUser user){
        tblUserService.saveUser(user);
        //return new RepositoryEntity<TblUser>(user,HttpStatus.ok);
        return ResponseEntity.ok(user);
    }
    @RequestMapping(value = "/User/{id}",method = RequestMethod.PUT)
    public void updateUser(@PathVariable("id") Long id,
                                              @RequestBody TblUser user){
        TblUser oldYUser = tblUserService.getOne(id);
        if(oldYUser==null){
             ResponseEntity.notFound().build();
        }else{
            oldYUser.setName(user.getName());
            oldYUser.setEmail(user.getEmail());
            oldYUser.setPhone(user.getPhone());
            tblUserService.saveUser(oldYUser);
            ResponseEntity.ok(user);
        }
    }

    @RequestMapping(value = "/User/{id}",method = RequestMethod.DELETE)
        public void deleteUser(@PathVariable("id") Long id){
            Optional<TblUser> oldUser = Optional.ofNullable(tblUserService.getOne(id));
            if(oldUser == null){
                 ResponseEntity.notFound().build();
            }else{
                tblUserService.deleteUser(id);
            }

    }
    //localhost:9090/lsUser
    @RequestMapping(value="/lsUser",method = RequestMethod.GET)
    public ResponseEntity<ListUser> listUser(){
        List<TblUser> listUser = tblUserService.getAllUser();
        ListUser ls = new ListUser();
        ls.setData(listUser);
        return new ResponseEntity<>(ls,HttpStatus.OK);

    }

}
