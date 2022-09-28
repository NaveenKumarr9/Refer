package com.thbs.restapi;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demo extends AbstractVerticle {
    private static final Logger LOGGER = LoggerFactory.getLogger(Demo.class);

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new Demo(),error->{
            if(error.failed())
            {
                LOGGER.error("Failed {}",error.cause());
            }else {
                LOGGER.info("Deployed successfully DemoVerticle");
            }
        });
    }

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
       final Router router = Router.router(vertx);
        router.get("/all").produces("application/json").handler(context->{
           final JsonArray jsonArray = new JsonArray();
            jsonArray
                    .add(new JsonObject().put("Naveen",1))
                    .add(new JsonObject().put("Prem",2))
                    .add(new JsonObject().put("Vishnu",3))
                    .add(new JsonObject().put("Shiva",4))
                    .add(new JsonObject().put("Ganesh",5));
            LOGGER.debug("path {} responds with {}",context.normalizedPath(),jsonArray);
            context.end(jsonArray.toBuffer());
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
