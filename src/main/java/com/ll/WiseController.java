package com.ll;

import java.util.ArrayList;
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
            if (input.equals("목록")){
                showWiseList();
            }
            if (input.matches("삭제\\?id=\\d+")){
                int id = Integer.parseInt(input.substring(6));
                deleteWise(id);
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

    public void showWiseList(){
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        ArrayList<String> totalWiseList = wiseService.getWiseList();
        totalWiseList.forEach(System.out::println);
    }

    public void deleteWise(int id){
        boolean result = wiseService.deleteWise(id);
        if (result) {
            System.out.println(id + "번 명언이 삭제되었습니다.");
        }
        if (!result){
            System.out.println(id + "번 명언은 존재하지 않습니다.");
        }
    }
}
