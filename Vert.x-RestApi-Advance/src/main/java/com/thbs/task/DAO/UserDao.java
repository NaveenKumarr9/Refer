package com.thbs.task.DAO;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.mysqlclient.MySQLConnectOptions;
import io.vertx.mysqlclient.MySQLPool;
import io.vertx.sqlclient.PoolOptions;
import io.vertx.sqlclient.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDao extends AbstractVerticle {
    public static final String ADDRESS = "Data";
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);

    private JsonObject salaryDetails(JsonObject details) {
        JsonObject saralDetails =  new JsonObject();
        saralDetails.put("experience",details.getJsonObject("experience"))
                    .put("salary",details.getJsonObject("salary"));
        return saralDetails;
    }

    private JsonObject projectDetails(JsonObject details) {
        /*JsonObject genieDetails = new JsonObject();
        genieDetails.put("project",details.getJsonObject("project"));*/
        JsonObject genieDetails = details.getJsonObject("project");
        return genieDetails;
    }

    private static MySQLPool getMySQLPool(Vertx vertx) {
        MySQLConnectOptions connectOptions = new MySQLConnectOptions()
                .setPort(3306)
                .setHost("127.0.0.1")
                .setDatabase("thbs")
                .setUser("root")
                .setPassword("root");
        PoolOptions pool = new PoolOptions().setMaxSize(40);
        MySQLPool client = MySQLPool.pool(vertx,connectOptions, pool);
        return client;
    }

    @Override
    public void start() throws Exception {
        MySQLPool client = getMySQLPool(vertx);

        vertx.eventBus().<JsonObject>consumer(ADDRESS,event ->{
            LOGGER.debug("Consumer: {}", event.body());

            client.getConnection()
                    .compose(misHandler -> {
                        return
                                client.preparedQuery("INSERT INTO mis (id,name,details) VALUES (?, ?, ?)")
                                        .execute(Tuple.of(event.body().getInteger("employee_id"), event.body().getString("name"), event.body().getString("details")))
                                        .compose(saralHandler -> {
                                            return
                                                    client.preparedQuery("INSERT INTO saral (id,name,salary_details) VALUES (?, ?, ?)")
                                                            .execute(Tuple.of(event.body().getInteger("employee_id"), event.body().getString("name"), salaryDetails(event.body().getJsonObject("details"))));
                                        }).compose(genieHandler -> {
                                            return
                                                    client.preparedQuery("INSERT INTO genie (id,name,project_details) VALUES (?, ?, ?)")
                                                            .execute(Tuple.of(event.body().getInteger("employee_id"), event.body().getString("name"), projectDetails(event.body().getJsonObject("details"))));
                                        });
                    }).onComplete(handler -> {
                        if (handler.succeeded()) {
                            LOGGER.debug("Rows Inserted Successfully");
                            event.reply(true);
                        } else {
                            LOGGER.error("Failed to insert rows {}", handler.cause().getMessage());
                           event.reply(false);
                        }
                    });
                   /* .onComplete(complete->{
                        LOGGER.debug("Rows Inserted Successfully");
                        event.reply(true);
                    }).onFailure(failure->{
                        LOGGER.error("Failed to insert rows {}", failure.getCause().getMessage());
                        event.reply(false);
                    });*/
        });
    }
}