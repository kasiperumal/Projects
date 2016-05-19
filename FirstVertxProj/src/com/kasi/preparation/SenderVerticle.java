package com.kasi.preparation;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class SenderVerticle extends AbstractVerticle {
	
	@Override
    public void start(Future<Void> startFuture) {
		vertx.eventBus().publish("anAddress", "message 2");
        vertx.eventBus().send("anAddress", "message 1");
    }

    @Override
    public void stop(Future stopFuture) throws Exception {
        System.out.println("SenderVerticle stopped!");
    }
}
