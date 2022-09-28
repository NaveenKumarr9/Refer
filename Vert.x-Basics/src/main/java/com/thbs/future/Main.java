package com.thbs.future;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.file.FileProps;
import io.vertx.core.file.FileSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();

       /* vertx.setPeriodic(500,id->{
           LOGGER.info("Printing");
        });*/

        FileSystem fs = vertx.fileSystem();

       /* Future<FileProps> future = fs.props("Data.txt");

        future.onComplete((AsyncResult<FileProps> ar) -> {
            if (ar.succeeded()) {
                FileProps props = ar.result();
                LOGGER.info("File size= {}", props.size());
            } else {
                LOGGER.error("Failure: {}", ar.cause().getMessage());
            }
        });*/
        Future<Buffer> future1 = fs.readFile("Happy.txt")
                .onComplete(res->{
                    if (res.failed()){
                        LOGGER.error("Failed due to {}",res.cause().getMessage());
                    }else {
                        LOGGER.debug("Data is ->{}",res.result());
                    }
                });

    }
}
