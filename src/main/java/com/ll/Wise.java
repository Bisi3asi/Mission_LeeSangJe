package com.ll;

import lombok.Getter;

public class Wise {
    @Getter
    private final int id;
    private static int nextId = 1;
    @Getter
    private final String content;
    @Getter
    private final String author;

    Wise(String content, String author){
        this.content = content;
        this.author = author;
        this.id = nextId;
        nextId++;
    }
}
