/*
package com.thbs.task.webclient;

import com.thbs.task.mysqlclient.Employee;
import com.thbs.task.mysqlclient.EmployeeDb;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestApi extends AbstractVerticle {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestApi.class);
    Router router = Router.router(vertx);
    EmployeeDb employeeDb = new EmployeeDb();
    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        router.route()
                .produces("application/json").consumes("application/json")
                .handler(BodyHandler.create())
                .handler(context -> {
                    context.next();
                }).failureHandler(failureHandler -> {
                    LOGGER.error("Routing Failed {}", failureHandler.failure().getMessage());
                    failureHandler.response().setStatusCode(500)
                            .putHeader("content-type", "application/json").end(new JsonObject()
                                    .put("Message", "Internal Server Error").encodePrettily());
                });

        router.get("/employee").handler(routingContext -> {
            routingContext.response()
                    .end(Json.encodePrettily(employeeDb.getAllEmployees()));
        });

        router.post("/employee").handler(routingContext->{
             Employee employee = Json.decodeValue(routingContext.body().asString(), Employee.class);
            employeeDb.createEmployee(employee);
            routingContext.response()
                    .end(Json.encodePrettily("Data Added Successfully!!!"));
        });

        router.put("/employee").handler(routingContext->{
             Employee employee = Json.decodeValue(routingContext.body().asString(), Employee.class);
            employeeDb.updateEmployee(employee);
            routingContext.response()
                    .end(Json.encodePrettily("Data Updated Successfully!!!"));
        });

        router.delete("/employee/:id").handler(handler->{
            int id = Integer.parseInt(handler.pathParam("id"));
            employeeDb.deleteEmployee(id);
            handler.response()
                    .end("Deleted Successfully");
        });
        vertx.createHttpServer().requestHandler(router).listen(8888,http->{
            if(http.failed()){
                startPromise.fail(http.cause().getCause().getMessage());
            }else {
                startPromise.complete();
                LOGGER.debug("Server started on {}",http.result().actualPort());
            }
        });
    }
}
*/
