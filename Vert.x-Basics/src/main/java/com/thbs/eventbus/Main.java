package com.thbs.eventbus;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.MessageConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        Vertx vertx=Vertx.vertx();
        EventBus eventBus = vertx.eventBus();

        MessageConsumer<String> consumer=eventBus.consumer("Data");
        consumer.handler(message->{
            LOGGER.debug("I have received a message-> {}", message.body());
        });

        eventBus.request("Data","Requesting",ar->{
            if(ar.succeeded()){
                LOGGER.debug("Received reply {}",ar.result());
            }else {
                LOGGER.error("Failed");
            }
        });
        eventBus.send("Data","Sending");
        eventBus.publish("Data","Published");

    }
}
