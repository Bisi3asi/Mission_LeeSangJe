package com.ll;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Wise {
    private static int nextId = 1;
    @Getter
    private final int id;
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
