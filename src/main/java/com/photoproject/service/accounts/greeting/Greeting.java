package com.photoproject.service.accounts.greeting;

/**
 * Simple resource representation class from the Spring REST Service Guide.
 *
 * @link https://spring.io/guides/gs/rest-service/
 */
public class Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
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
