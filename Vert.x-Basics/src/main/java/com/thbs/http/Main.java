package com.thbs.http;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        HttpServer server = vertx.createHttpServer();
        server.requestHandler(event -> {
            LOGGER.info(event.body().toString());
            event.response().setStatusCode(200).end("Hello Naveen");
        }).listen(8080, "localhost",res->{
            if(res.failed()){
                LOGGER.error("Failed");
            }
            LOGGER.debug("server is now listening to {}", server.actualPort());
        });
    }
}
