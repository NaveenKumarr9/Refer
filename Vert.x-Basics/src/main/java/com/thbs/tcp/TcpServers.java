package com.thbs.tcp;

import io.vertx.core.Vertx;
import io.vertx.core.net.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TcpServers {
    private static final Logger LOGGER = LoggerFactory.getLogger(TcpServers.class);
    public static void main(String[] args) {
        Vertx vertx=Vertx.vertx();

        NetServer server= vertx.createNetServer();
        server.connectHandler(socket ->{
            socket.handler(buffer ->{
               // socket.sendFile("details.txt");
                LOGGER.debug("Received some bytes {}",buffer.length());
            });
        }).listen(8088,"localhost", res->{
            if(res.succeeded()){
                LOGGER.debug("server is now listening to {}",server.actualPort());
            }else{
                LOGGER.error("Failed to connect {}",res.cause().getMessage());
            }
        });/*.close(res ->{
            if(res.succeeded()){
                LOGGER.info("Server is closed");
            }else {
                LOGGER.error("Failed to close");
            }
        });*/

        NetClientOptions options = new NetClientOptions().setConnectTimeout(10000);
        NetClient client = vertx.createNetClient(options);
        client.connect(8088, "localhost", res -> {
            if (res.succeeded()) {
                LOGGER.debug("Connected!");
                NetSocket socket = res.result();
            } else {
                LOGGER.error("Failed to connect: " + res.cause().getMessage());
            }
        });
    }
}
