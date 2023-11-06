package com.ll;

public class Application {
    WiseController wiseController = new WiseController();

    public void boot(){
        wiseController.start();
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.boot();
    }
}
