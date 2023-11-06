package com.ll;

import java.util.ArrayList;
import java.util.List;

public class WiseRepository {
    List<Wise> wiseList = new ArrayList<>();

    public int postWise(String content, String author) {
        wiseList.add(new Wise(content, author));
        // 생성된 명언의 id값 리턴
        return wiseList.get(wiseList.size()-1).getId();
    }
}
