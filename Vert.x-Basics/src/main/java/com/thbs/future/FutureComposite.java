package com.thbs.future;

import io.vertx.core.AsyncResult;
import io.vertx.core.CompositeFuture;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.file.FileSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FutureComposite {
    private static final Logger LOGGER = LoggerFactory.getLogger(FutureComposite.class);

    public static void main(String[] args) {

        String FileName = "Data.txt";
        String RenamingFile = "File.txt";
        String FileContent = "Naveen.";

        Vertx vertx = Vertx.vertx();
        FileSystem fileSystem = vertx.fileSystem();

        Future<Void>futureOne = fileSystem.createFile(FileName)
                .onComplete(fileCreateHandler ->{
                    if(fileCreateHandler.succeeded()){
                        LOGGER.debug("File Created!!!");
                    }else {
                        LOGGER.error("Failed to create file due to {}",fileCreateHandler.cause().getMessage());
                    }
                });

        Future<Void>futureTwo = fileSystem.move(FileName,RenamingFile)
                .onComplete(fileRenameHandler ->{
                    if(fileRenameHandler.succeeded()){
                        LOGGER.debug("Renamed File!!!");
                    }else {
                        LOGGER.error("Failed to Rename the file due to {}",fileRenameHandler.cause().getMessage());
                    }
                });

        Future<Void>futureThree = fileSystem.writeFile(RenamingFile, Buffer.buffer(FileContent))
                .onComplete(fileWriteHandler ->{
                    if(fileWriteHandler.succeeded()){
                        LOGGER.debug("Data Written!!!");
                    }else {
                        LOGGER.error("Failed to writedata due to {}",fileWriteHandler.cause().getMessage());
                    }
                });

        CompositeFuture.any(futureOne,futureTwo,futureThree)
                .onComplete(asyncResult ->{
                    if (asyncResult.succeeded()){
                        LOGGER.debug("ANY Futures executed {}",asyncResult.result());
                        LOGGER.debug("ANY Result is {}",asyncResult.result().list());
                    }else {
                        LOGGER.error("Failed to execute due to {}",asyncResult.cause().getMessage());
                    }
                });

        /*CompositeFuture.all(futureOne,futureTwo,futureThree)
                .onComplete(asyncResult ->{
                    if (asyncResult.succeeded()){
                        LOGGER.debug("All Futures executed ");
                        LOGGER.debug("ALL Result is {}",asyncResult.result().list());
                    }else {
                        LOGGER.error("Failed to execute due to {}",asyncResult.cause().getMessage());
                    }
                });*/

        /*CompositeFuture.join(futureOne,futureTwo,futureThree)
                .onComplete(asyncResult ->{
                    if (asyncResult.succeeded()){
                        LOGGER.debug("JOIN Futures executed ");
                        LOGGER.debug("JOIN Result is {}",asyncResult.result().list());
                    }else {
                        LOGGER.error("Failed to execute due to {}",asyncResult.cause().getMessage());
                    }
                });*/
    }
}
