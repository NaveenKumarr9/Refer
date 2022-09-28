package com.thbs.future;

import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.file.FileSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FutureTask {
    private static final Logger LOGGER = LoggerFactory.getLogger(FutureTask.class);
    public static void main(String[] args) {

        String FileName = "Data.txt";
        String RenamingFile = "File.txt";
        String FileContent = "Naveen.";

        Vertx vertx= Vertx.vertx();
        FileSystem fileSystem = vertx.fileSystem();

        Future<Buffer> future = fileSystem.createFile(FileName)
                .onComplete(fileCreateHandler ->{
                   if(fileCreateHandler.succeeded()){
                       LOGGER.debug("File Created!!! {}", fileCreateHandler.result());
                   }else{
                       LOGGER.error("Failed to create {}",fileCreateHandler.cause().getMessage());
                   }
                })
                .compose(fileRenameHandler ->{
                    return  fileSystem.move(FileName,RenamingFile)
                            .onComplete(asyncResult ->{
                                if (asyncResult.succeeded()){
                                    LOGGER.debug("Renamed File Successfully!!! {}",asyncResult.result());
                                }else {
                                    LOGGER.error("Failed to rename {}",asyncResult.cause().getMessage());
                                }
                            })
                .compose(fileWritingHandler ->{
                   return  fileSystem.writeFile(RenamingFile, Buffer.buffer(FileContent))
                           .onComplete(asyncResult ->{
                               if (asyncResult.succeeded()){
                                   LOGGER.debug("Data Written!!! {}",asyncResult.result());
                               }else {
                                   LOGGER.error("Failed to write data {}",asyncResult.cause().getMessage());
                               }
                           })
                           .compose(fileReadingHandler ->{
                               return fileSystem.readFile(RenamingFile)
                                       .onComplete(asyncResult->{
                                           if (asyncResult.succeeded()){
                                               LOGGER.debug("Data is {}",asyncResult.result());
                                           }else {
                                               LOGGER.error("Unable to get the data {}",asyncResult.cause().getMessage());
                                           }
                                       });
                           });

                           });
                });
    }
}
