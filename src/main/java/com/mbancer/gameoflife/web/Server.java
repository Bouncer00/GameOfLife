package com.mbancer.gameoflife.web;


import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.ext.web.handler.sockjs.SockJSHandler;
import io.vertx.ext.web.handler.sockjs.SockJSHandlerOptions;

import java.util.logging.Logger;

public class Server {

    private final static Logger LOG = Logger.getLogger(Server.class.getName());

    private final Vertx vertx;
    private final HttpServer server;
    private final int port;

    public Server(final int port){
        this.port = port;
        vertx = Vertx.vertx();
        server = vertx.createHttpServer();
    }

    /**
     * Create mappings and listen on given port
     */
    public void listen(){
        LOG.info("Creating mappings");
        final Router router = createMappings();
        LOG.info("Starting server");
        server.requestHandler(router::accept).listen(port);
        LOG.info(String.format("Server started at port: %d", port));
    }

    private Router createMappings(){
        final Router router = Router.router(vertx);

        configureServingStaticFiles(router);
        configureWebSocket(router);

        return router;
    }

    private void configureServingStaticFiles(final Router router){
        router.route().handler(StaticHandler.create());
    }

    private void configureWebSocket(final Router router) {
        final SockJSHandlerOptions options = new SockJSHandlerOptions().setHeartbeatInterval(2000);
        final SockJSHandler sockJSHandler = SockJSHandler.create(vertx, options);

        sockJSHandler.socketHandler(event -> {
            event.handler(event::write);
        });

        router.route("/game/*").handler(sockJSHandler);
    }
}
