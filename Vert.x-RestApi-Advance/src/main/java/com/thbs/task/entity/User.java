package com.thbs.task.entity;

import io.vertx.core.json.JsonObject;

public class User {
    private Integer id;
    private String name;
    private JsonObject details;

    public User() {
    }

    public User(Integer id, String name, JsonObject details) {
        this.id = id;
        this.name = name;
        this.details = details;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JsonObject getDetails() {
        return details;
    }

    public void setDetails(JsonObject details) {
        this.details = details;
    }
}
