package com.thbs.http;

import io.vertx.core.Vertx;

public class Deomo {
    static int timercount=0;
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.setPeriodic(1000,handler->{
           int count =0;
            System.out.println("stat");
           for(count=0;count<5;count++){
               if(count==0){
                   System.out.println("loop staeted" + timercount);
               }
               System.out.println("loop ended");
           }
        });
    }
}
