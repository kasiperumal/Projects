package com.kasi.preparation;

import io.vertx.core.Vertx;

public class VertxApp {

	public static void main(String[] args) {
		Vertx vertx = Vertx.vertx();
		vertx.deployVerticle(new ReceiverVerticle("R1"), stringAsyncResult -> {
			System.out.println("ReceiverVerticle R1 deployment complete");
		});
		vertx.deployVerticle(new ReceiverVerticle("R2"), stringAsyncResult -> {
			System.out.println("ReceiverVerticle R2 deployment complete");
		});
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		vertx.deployVerticle(new SenderVerticle(), stringAsyncResult -> {
			System.out.println("SenderVerticle deployment complete");
		});
		
	}

}
