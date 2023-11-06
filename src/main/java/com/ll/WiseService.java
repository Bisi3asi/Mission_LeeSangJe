package com.ll;

public class WiseService {
    WiseRepository wiseRepository = new WiseRepository();

    // 생성할 명언을 repository로, 생성된 명언의 id를 controller로 전달
    public int postWise(String content, String author){
        int id = wiseRepository.postWise(content, author);
        return id;
    }
}
