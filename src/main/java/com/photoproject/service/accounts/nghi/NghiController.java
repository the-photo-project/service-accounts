package com.photoproject.service.accounts.nghi;

import com.photoproject.service.accounts.nghi.Nghi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class NghiController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/nghi")
    public Nghi nghi(@RequestParam(value = "nname", defaultValue = "0") String nname) {

        int n;
        String result = "";

        n = Integer.parseInt(nname);
        for (int i=100; i<1000; i++) {
            int tong=0, a, b, c;

            a = i / 100;
            b = (i % 100) / 10;
            c = i % 10;
            tong = a + b + c;
            if (tong == n) {
                result = String.format("%s %s", result, n);
            }
        }

        return new Nghi(counter.incrementAndGet(), result);
    }
}
