package com.thbs.tasks;

import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.MessageCodec;

public class SimpleMessageCodec implements MessageCodec {
    private final Class pojoClass;

    public SimpleMessageCodec(Class pojoClass) {
        this.pojoClass=pojoClass;
    }

    @Override
    public void encodeToWire(Buffer buffer, Object o) {

    }

    @Override
    public Object decodeFromWire(int pos, Buffer buffer) {
        return null;
    }

    @Override
    public Object transform(Object o) {
        return o;
    }

    @Override
    public String name() {
        return pojoClass.getName() + "codec";
    }

    @Override
    public byte systemCodecID() {
        return -1;
    }
}
