package com.thbs.json;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        JsonObject object = new JsonObject();
        object.put("foo", "bar").put("num", 123).put("mybool", true);

        Map<String, Object> map = new HashMap<>();
        map.put("foo", "bar");
        map.put("xyz", 3);
        //JsonObject object = new JsonObject(map);

        JsonArray array = new JsonArray();
        array.add("foo").add(123).add(true);
        System.out.println(array);
    /*String val = array.getString(0);
    System.out.println(val);
    Integer intVal = array.getInteger(1);
    System.out.println(intVal);
    Boolean boolVal = array.getBoolean(2);
    System.out.println(boolVal);*/
    }
}
