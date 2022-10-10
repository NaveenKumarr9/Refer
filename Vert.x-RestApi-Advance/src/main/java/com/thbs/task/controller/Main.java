package com.thbs.task.controller;

import com.thbs.task.DAO.UserDao;
import io.vertx.core.Vertx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
         Vertx vertx = Vertx.vertx();

         vertx.deployVerticle(new UserController(), res->{
             if (res.failed()){
                 LOGGER.error("Failed {}", res.cause().getMessage());
             }else {
                 vertx.deployVerticle(new UserDao());
                 LOGGER.debug("Deployed Successfully");
             }
         });

    }
}
