package com.ll;

import java.util.Scanner;

public class Application {
    WiseController wiseController = new WiseController(new Scanner(System.in));

    public void boot(){
        wiseController.start();
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.boot();
    }
}
