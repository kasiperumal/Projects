package com.kasi.preparation;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class ReceiverVerticle extends AbstractVerticle {
    
	private String name = null;
	
	
    public ReceiverVerticle(String name) {
		this.name = name;
	}

	@Override
    public void start(Future<Void> startFuture) {
        vertx.eventBus().consumer("anAddress", message -> {
        	System.out.println("Receiver [" + name + "] received message:" + message.body());
        });
    }

    @Override
    public void stop(Future stopFuture) throws Exception {
        System.out.println("ReceiverVerticle stopped!");
    }
}
