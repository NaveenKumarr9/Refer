package com.thbs.task.controller;

import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.MessageCodec;

public class SimpleMessageCodec<T> implements MessageCodec<T,T> {


    @Override
    public void encodeToWire(Buffer buffer, Object o) {

    }

    @Override
    public T decodeFromWire(int pos, Buffer buffer) {
        return null;
    }

    @Override
    public Object transform(Object o) {
        return o;
    }

    @Override
    public String name() {
        return this.getClass().getName();
    }

    @Override
    public byte systemCodecID() {
        return -1;
    }
}
