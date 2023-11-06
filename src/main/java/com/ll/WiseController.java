package com.ll;

import java.util.Scanner;

public class WiseController {
    WiseService wiseService = new WiseService();
    private final Scanner sc;

    public WiseController(Scanner sc){
        this.sc = sc;
    }

    void start(){
        boolean isQuit = false;
        System.out.println("== 명언 앱 == ");
        while(!isQuit){
            String input = returnInput();
            if (input.equals("등록")){
                postWise();
            }
            if (input.equals("종료")){
                isQuit = true;
            }
        }
    }

    String returnInput(){
        System.out.print("명령) ");
        return sc.nextLine();
    }

    public void postWise(){
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        int id = wiseService.postWise(content, author);
        System.out.println(id+"번 명언이 등록되었습니다.");
    }
}
