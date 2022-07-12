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
        DataResponde result = new DataResponde();

        if (a == 0) {
            if (b == 0) {
                result.setMsg("Phương trình vô nghiệm");
                return result;
            } else {
                result.setMsg("Phương trình có nghiệm kép");
                result.setX1((float)(-c/b));
                result.setX2((float)(-c/b));
                return result;
            }
        }
        float delta = b * b - 4 * a * c;
        float x1;
        float x2;
        if (delta > 0) {
            x1 = (float) ((-b + Math.sqrt(delta)) / (2 * a));
            x2 = (float) ((-b - Math.sqrt(delta)) / (2 * a));
            result.setMsg("Phương trình có 2 nghiệm");
            result.setX1(x1);
            result.setX2(x2);
            return result;
        } else if (delta == 0) {
            x1 = ((float)-b / (2 * a));
            result.setX1(x1);
            result.setMsg("Phương trình có nghiệm kép");
            return result;
        } else {
            result.setMsg("Phương trình vô nghiệm");
            return result;
        }
    }
}
