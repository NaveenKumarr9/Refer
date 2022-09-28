package com.thbs.jsonpointers;

import io.vertx.core.json.pointer.JsonPointer;

public class JsonPointers {
    public static void main(String[] args) {
        JsonPointer pointer1 = JsonPointer.from("/hello/world");
        Object result1 = pointer1.queryJson(pointer1);

    }
}
