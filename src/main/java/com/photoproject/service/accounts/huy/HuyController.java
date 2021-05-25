package com.photoproject.service.accounts.huy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HuyController {

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

        return new Huy(ngay, h, m, s);
    }
}
