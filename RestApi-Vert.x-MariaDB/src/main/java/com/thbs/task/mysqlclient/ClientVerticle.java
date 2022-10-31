package com.thbs.task.mysqlclient;

import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.ext.web.client.HttpResponse;
import io.vertx.ext.web.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientVerticle {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientVerticle.class);

    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();

        WebClient client = WebClient.create(vertx);

        Future<HttpResponse<Buffer>> future = vertx.deployVerticle(new EmployeeServer())
                .onComplete(result -> {
            if (result.succeeded()) {
                LOGGER.info("Verticle Deployed");
            } else {
                LOGGER.error("Failed to deploy Verticle {}", result.cause().getMessage());
            }
        }).compose(postHandler -> {
            return client.post(8888, "localhost", "/employee").sendJson(new Employee("Kumar", "1999-07-16", "B.TECH", "Kadapa"));
        }).onComplete(result -> {
            if (result.succeeded()) {
                LOGGER.debug("POST data is: {}", result.result().bodyAsString());
            } else {
                LOGGER.error("Failed to get POST response: {}", result.cause().getMessage());
            }
        }).compose(getHandler -> {
            return client.get(8888, "localhost", "/employee").send();
        }).onComplete(result -> {
            if (result.succeeded()) {
                LOGGER.debug("GET data  is {}", result.result().bodyAsString());
            } else {
                LOGGER.error("Failed to get GET response: {}", result.cause().getMessage());
            }
        }).compose(putHandler -> {
            return client.put(8888, "localhost", "/employee").sendJson(new Employee(1, "Naveen", "1998-07-16", "B.TECH", "Kadapa"));
        }).onComplete(result -> {
            if (result.succeeded()) {
                LOGGER.debug("PUT data is: {}", result.result().bodyAsString());
            } else {
                LOGGER.error("Failed to get PUT response: {}", result.cause().getMessage());
            }
        }).compose(deleteHandler -> {
            return client.delete(8888, "localhost", "/employee/2").send();
        }).onComplete(result -> {
            if (result.succeeded()) {
                LOGGER.info("Deleted data successfully!!! {}", result.result().bodyAsString());
            } else {
                LOGGER.error("Failed to delete data {}", result.cause().getMessage());
            }
        });
    }
}



    /* @Override
    public void start(Promise<Void> startPromise) throws Exception {
        super.start();
        WebClient client = WebClient.create(vertx);
        *//*client.post(8888, "localhost", "/employee").sendJson(new Employee("Kumar", "1999-07-16", "B.TECH", "Kadapa"))
                .onComplete(result -> {
                    if (result.succeeded()) {
                        LOGGER.debug("POST data is: {}", result.result().bodyAsString());
                    } else {
                        LOGGER.error("Failed to get POST response: {}", result.cause().getMessage());
                    }
                });*//*

        client.get(8888, "localhost", "/employee").send()
                .onComplete(result -> {
                    if (result.succeeded()) {
                        LOGGER.debug("GET data  is {}", result.result().bodyAsString());
                    } else {
                        LOGGER.error("Failed to get GET response: {}", result.cause().getMessage());
                    }
                });

       *//* client.put(8888, "localhost", "/employee").sendJson(new Employee(1, "Naveen", "1998-07-16", "B.TECH", "Kadapa"))
                .onComplete(result -> {
                    if (result.succeeded()) {
                        LOGGER.debug("PUT data is: {}", result.result().bodyAsString());
                    } else {
                        LOGGER.error("Failed to get PUT response: {}", result.cause().getMessage());
                    }
                });

        client.delete(8888, "localhost", "/employee/2").send()
                .onComplete(result -> {
                    if (result.succeeded()) {
                        LOGGER.debug("Deleted data successfully!!!", result.result().bodyAsString());
                    } else {
                        LOGGER.error("Failed to delete data", result.cause().getMessage());
                    }
                });*//*
        startPromise.complete();
*/