package com.thbs.task.mysqlclient;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeServer extends AbstractVerticle {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServer.class);
    Router router = Router.router(vertx);
    EmployeeDb employeeDb = new EmployeeDb();

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        router.route()
                .handler(BodyHandler.create())
                .handler(context -> {
                    context.next();
                }).failureHandler(failureHandler -> {
                    LOGGER.error("Routing Failed {}", failureHandler.failure().getMessage());
                    failureHandler.response().setStatusCode(500)
                            .putHeader("content-type", "application/json").end(new JsonObject()
                                    .put("Message", "Internal Server Error").encodePrettily());
                });

        router.get("/employee")
                .handler(handler -> {
            handler.response()
                    .putHeader("content-type","application/xml")
                    .end(Json.encodePrettily(employeeDb.getAllEmployees()));
            LOGGER.debug("GET path [{}] is responding", handler.normalizedPath());
        });

        router.post("/employee")
                .handler(handler -> {
             Employee employee = Json.decodeValue(handler.body().asString(), Employee.class);
            employeeDb.createEmployee(employee);
            handler.response()
                    .putHeader("content-type","application/json")
                    .end(Json.encodePrettily("Data Added Successfully!!!"));
            LOGGER.debug("POST path [{}] is responding ", handler.normalizedPath());

        });

        router.put("/employee")
                .handler(handler -> {
             Employee employee = Json.decodeValue(handler.body().asString(), Employee.class);
            employeeDb.updateEmployee(employee);
            handler.response()
                    .putHeader("content-type","application/json")
                    .end(Json.encodePrettily("Data Updated Successfully!!!"));
            LOGGER.debug("PUT path [{}] is responding ", handler.normalizedPath());
        });

        router.delete("/employee/:id")
                .handler(handler -> {
            int id = Integer.parseInt(handler.pathParam("id"));
            employeeDb.deleteEmployee(id);
            handler.response()
                    .putHeader("content-type","application/json")
                    .end("Deleted Successfully");
            LOGGER.debug("DELETE path [{}] is responding ", handler.normalizedPath());
        });

        vertx.createHttpServer()
                .requestHandler(router).listen(8888,http->{
            if(http.failed()){
                startPromise.fail(http.cause().getCause().getMessage());
            }else {
                startPromise.complete();
                LOGGER.info("Server started on {}",http.result().actualPort());
            }
        });

    }
}
