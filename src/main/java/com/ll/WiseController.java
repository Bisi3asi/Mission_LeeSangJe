package com.ll;

import java.util.Scanner;

public class WiseController {
    WiseService wiseService = new WiseService();
    Scanner sc = new Scanner(System.in);

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

    void postWise(){
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();
        wiseService.postWise(content, author);
    }
}
