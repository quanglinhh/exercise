package com.example.springbootex.controller.Ex2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Bai2 {
    @GetMapping("/msg")
    public DataResponde equation(@RequestParam int a, @RequestParam int b,@RequestParam int c) {
        DataResponde voNghiem = new DataResponde("Phương trình vô nghiệm");
        DataResponde nghiemKep= new DataResponde("Phương trình có nghiệm kép");
        DataResponde haiNghiem = new DataResponde("Phương trình có 2 nghiệm");
        if (a == 0) {
            if (b == 0) {

                return voNghiem;
            } else {
                nghiemKep.setX1((float)(-c/b));
                nghiemKep.setX2((float)(-c/b));
                return nghiemKep;
            }
        }
        float delta = b * b - 4 * a * c;
        float x1;
        float x2;
        if (delta > 0) {
            x1 = (float) ((-b + Math.sqrt(delta)) / (2 * a));
            x2 = (float) ((-b - Math.sqrt(delta)) / (2 * a));
            haiNghiem.setX1(x1);
            haiNghiem.setX2(x2);
            return haiNghiem;
        } else if (delta == 0) {
            x1 = ((float)-b / (2 * a));
            nghiemKep.setX1(x1);
            return nghiemKep;
        } else {
            return voNghiem;
        }
    }
}
