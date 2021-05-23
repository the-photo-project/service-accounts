package com.photoproject.service.accounts.huy;

import com.photoproject.service.accounts.huy.Huy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HuyController {

    private static final String template = "thoi gian sau khi doi la: %d ngay %d gio %d phut %d giay";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/huy")
    public Huy huy(@RequestParam(value = "tname", defaultValue = "0") String tname) {

        int h, s, m, t, ngay=0;
        t = Integer.parseInt(tname);

        h = t / 3600;
        t = t % 3600;
        m = t / 60;
        s = t % 60;
        while (h > 24) {
            ngay++;
            h = h - 24;
        }

        return new Huy(counter.incrementAndGet(), String.format(template, ngay, h, m, s));
    }
}
