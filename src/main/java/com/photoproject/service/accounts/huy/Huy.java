package com.photoproject.service.accounts.huy;

public class Huy {

    private final long id;
    private final String content;

    public Huy(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
