package com.demo.communique.entity;

import java.util.UUID;

public record ArticleListResponse(String title)  {
    public static Tweet emptyResponse(){
        return new Tweet(UUID.randomUUID(), "Default response");
    }
}
