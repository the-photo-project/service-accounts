package com.photoproject.service.accounts.nghi;

public class Nghi {

    private final long id;
    private final String content;

    public Nghi(long id, String content) {
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
