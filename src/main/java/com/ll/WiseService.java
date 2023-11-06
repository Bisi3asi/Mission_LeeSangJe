package com.ll;

public class WiseService {
    WiseRepository wiseRepository = new WiseRepository();

    public void postWise(String content, String author){
        wiseRepository.postWise(content, author);
    }
}
