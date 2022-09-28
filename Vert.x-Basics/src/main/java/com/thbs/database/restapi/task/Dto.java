package com.thbs.database.restapi.task;

import io.vertx.mysqlclient.MySQLConnectOptions;
import io.vertx.mysqlclient.MySQLPool;
import io.vertx.sqlclient.PoolOptions;
import io.vertx.sqlclient.Row;
import io.vertx.sqlclient.RowSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

public class Dto {
    private static final Logger LOGGER = LoggerFactory.getLogger(Dto.class);
    public static void main(String[] args) {
        MySQLConnectOptions connectOptions = new MySQLConnectOptions()
                .setPort(3306)
                .setHost("127.0.0.1")
                .setDatabase("task")
                .setUser("root")
                .setPassword("root");

        PoolOptions poolOptions = new PoolOptions().setMaxSize(5);

        MySQLPool client = MySQLPool.pool(connectOptions, poolOptions);

        client.getConnection().compose(conn->{
            LOGGER.info("Connected");
            return conn.query("SELECT * from employee").execute().onComplete(res->{
                if (res.failed()){
                    LOGGER.error("Failed due to {}",res.cause().getMessage());
                }else {
                    LOGGER.debug("Done {}",res.result());
                }
            });
        });

        /*client.query("SELECT * from employee").execute(ar -> {
            if (ar.succeeded()) {
                RowSet<Row> result = ar.result();
                LOGGER.info("Result {} rows",result.size());
                LOGGER.info("Data is {}",result.getClass());
            }else {
                LOGGER.error("Failed due to {}",ar.cause().getMessage());
            }
        });
        client.close();*/
    }
}
