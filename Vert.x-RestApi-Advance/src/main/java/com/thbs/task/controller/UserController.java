package com.thbs.task.controller;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.thbs.task.DAO.UserDao.ADDRESS;

public class UserController extends AbstractVerticle {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    Router router = Router.router(vertx);

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        router.route()
                .handler(BodyHandler.create())
                .handler(context -> {
                    context.next();
                }).failureHandler(failureHandler -> {
                    LOGGER.error("Routing Failed {}", failureHandler.failure().getMessage().toString());
                    failureHandler.response().setStatusCode(500)
                            .putHeader("content-type", "application/json").end(new JsonObject()
                                    .put("Message", "Internal Server Error").encodePrettily());
                });

        router.post("/employee")
                .handler(handler -> {
                            JsonObject user = handler.body().asJsonObject();
                    vertx.eventBus()
                            .request(ADDRESS, user, replyHandler -> {
                               // LOGGER.warn("Message-{}", replyHandler.result().body());
                                if (replyHandler.succeeded()) {
                                   // String reply = replyHandler.result().body().toString();
                                    boolean d = (boolean) replyHandler.result().body();
                                    if (d) {
                                        handler.response()
                                                .setStatusCode(201)
                                                .putHeader("content-type", "application/json")
                                                .end(new JsonObject().put("response", "Data added successfully").encodePrettily());
                                    } else {
                                        handler.response()
                                                .setStatusCode(400)
                                                .putHeader("content-type", "application/json")
                                                .end(new JsonObject().put("Message", "Bad Request").encodePrettily());
                                    }
                                }else {
                                    handler.response()
                                            .setStatusCode(400)
                                            .putHeader("content-type", "application/json")
                                            .end(new JsonObject().put("Message", "server error").encodePrettily());
                                }
                            });
                        });

        vertx.createHttpServer()
                .requestHandler(router).listen(9999, http -> {
                    if (http.failed()) {
                        startPromise.fail(http.cause().getCause().getMessage());
                    } else {
                        startPromise.complete();
                        LOGGER.info("Server started on {}", http.result().actualPort());
                    }
                });
    }
}
