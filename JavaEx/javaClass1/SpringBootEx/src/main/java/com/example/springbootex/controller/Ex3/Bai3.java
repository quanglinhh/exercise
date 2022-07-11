package com.example.springbootex.controller.Ex3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Bai3 {
    @GetMapping("/chuyentien")
    public String chuyentien(@RequestParam String loaitien, @RequestParam int sotien){
        if(loaitien.equals("USD")){
            return "Chuyển tiền thành công từ "+sotien+"VND sang " +sotien*23000L+" USD";
        }else if(loaitien.equals("EUR")){
            return "Chuyển tiền thành công từ "+sotien+"VND sang "+sotien*23783L+" EUR";
        }else if(loaitien.equals("JPY")){
            return "Chuyển tiền thành công từ "+sotien+"VND sang "+sotien*17163L+" JPY";
        }else{
            return "Không tìm thấy";
        }
    }
}
