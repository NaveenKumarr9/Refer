package com.thbs.rest.task;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;

public class StudentVerticle extends AbstractVerticle {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentVerticle.class);
    Map<Integer,Student> StudentMap = new HashMap<>();
    static Vertx vertx = Vertx.vertx();
    Router router = Router.router(vertx);

    private void studentData(){
        Student student = new Student(01,"Naveen","A");
        Student student1 = new Student(02,"Kumar","B");
        StudentMap.put(student.getRollNo(),student);
        StudentMap.put(student1.getRollNo(),student1);
    }
    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        studentData();
        router.route().produces("application/json").consumes("application/json")
                .handler(BodyHandler.create()).failureHandler(failureHandler->{
                    LOGGER.error("Routing Failed {}",failureHandler.failure().getMessage());
                    failureHandler.response().setStatusCode(500)
                            .putHeader("content-type","application/json").end(new JsonObject()
                                    .put("Message","Internal Server Error").encodePrettily());
                }).handler(context->{
                context.next();
                });
        router.get("/getAllStudents")
                .handler(context->{
            context.response().end(Json.encodePrettily(StudentMap.values()));
            LOGGER.debug("path [{}] is responding {}",context.normalizedPath(),StudentMap);
        });

        router.post("/addStudent").handler(context->{
            Student student = Json.decodeValue(context.body().asString(),Student.class);
            StudentMap.put(student.getRollNo(), student);
            context.response().end(Json.encodePrettily(student));
            LOGGER.debug("path [{}] is responding {}",context.normalizedPath(),StudentMap);
        });

        router.put("/updateStudent").handler(context->{
            Student student = Json.decodeValue(context.body().asString(),Student.class);
            StudentMap.put(student.getRollNo(), student);
            context.response().end(Json.encodePrettily(student));
            LOGGER.debug("path [{}] is responding {}",context.normalizedPath(),StudentMap);
        });

        router.delete("/deleteStudent/:id").handler(context->{
            StudentMap.remove(Integer.parseInt(context.pathParam("id")));
            context.response().end("Deleted Successfully");
            LOGGER.debug("path [{}] is responding {}",context.normalizedPath(),StudentMap);
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
