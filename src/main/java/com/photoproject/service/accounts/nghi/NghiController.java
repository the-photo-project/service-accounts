package com.photoproject.service.accounts.nghi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class NghiController {

    @GetMapping("/nghi")
    public ArrayList<Integer> nghi(@RequestParam(value = "nname", defaultValue = "0") String nname) {

        int n;
        ArrayList<Integer> result = new ArrayList<>();

        n = Integer.parseInt(nname);
        for (Integer i = 100; i<1000; i++) {
            int tong, a, b, c;

            a = i / 100;
            b = (i % 100) / 10;
            c = i % 10;
            tong = a + b + c;
            if (tong == n) {
                result.add(i);
            }
        }

        return result;
    }
}
