package com.nelolik.HelloWorld;

public class Greeting {

    private final long id;
    private final String context;

    public Greeting(long id, String context) {
        this.id = id;
        this.context= context;
    }

    public long getId() {
        return id;
    }

    public String getContext() {
        return context;
    }
}
