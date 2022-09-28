package com.thbs.rest.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.thbs.rest.task.StudentVerticle.vertx;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        vertx.deployVerticle(new StudentVerticle(),handler->{
            if (handler.failed()){
                LOGGER.error("Failed due to {}",handler.cause());
            }else {
                LOGGER.debug("Deployed Successfully");
            }
        });

    }
}
