package com.ll;

import java.util.ArrayList;
import java.util.List;

public class WiseRepository {
    List<Wise> wiseList = new ArrayList<>();

    public void postWise(String content, String author) {
        wiseList.add(new Wise(content, author));
    }

}
