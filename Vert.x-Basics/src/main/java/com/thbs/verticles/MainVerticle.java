package com.thbs.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainVerticle extends AbstractVerticle {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainVerticle.class);
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new MainVerticle());
    }

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        LOGGER.debug("start--{}" , getClass().getName());
        vertx.deployVerticle(new VerticleA(), whenDeployed ->{
            LOGGER.debug("Deployed--{}", VerticleA.class.getName());
            vertx.undeploy(whenDeployed.result());
        });
        startPromise.complete();
    }

}
