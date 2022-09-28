package com.thbs.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VerticleA extends AbstractVerticle {
    private static final Logger LOGGER = LoggerFactory.getLogger(VerticleA.class);
    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        LOGGER.debug("start--{}", getClass().getName());
        startPromise.complete();
    }
}
