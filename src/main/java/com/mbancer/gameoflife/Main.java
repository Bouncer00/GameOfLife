package com.mbancer.gameoflife;

import com.mbancer.gameoflife.web.Server;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {

        new Server(8090).listen();
    }
}
