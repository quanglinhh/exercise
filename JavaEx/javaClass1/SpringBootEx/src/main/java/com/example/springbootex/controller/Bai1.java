package com.example.springbootex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Bai1 {
    @GetMapping("/additonal")
    public int additional(@RequestParam int a ,
                            @RequestParam int b
                          ){
        return a+b;
    }
    @GetMapping("/subtraction")
    public int subtraction(@RequestParam int a ,
                           @RequestParam int b){
        return a-b;
    }
    @GetMapping("/multiplication")
    public int multiplication(@RequestParam int a ,
                              @RequestParam int b){
        return a*b;
    }
    @GetMapping("/division")
    public String division(@RequestParam int a ,
                        @RequestParam int b){
        try{
            return String.valueOf(a/b);
        }catch (Exception e){
           return "Khong duoc chia cho 0";
        }

    }
}
