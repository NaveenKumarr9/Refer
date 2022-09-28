package com.thbs.tasks;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new EmpVerticle(),logOnError());
            vertx.deployVerticle(new ProjectVerticle(),logOnError());

    }
    private static Handler<AsyncResult<String>> logOnError(){
        return ar -> {
            if (ar.failed()){
                LOGGER.error("Error: ", ar.cause());
            }
        };
    }
}
