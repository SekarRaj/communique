package com.demo.communique.client;

import com.demo.communique.entity.Tweet;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class ArticleClient {
    private final WebClient client;

    public ArticleClient(WebClient.Builder clientBuilder) {
        this.client = clientBuilder.baseUrl("http://localhost:8080").build();
    }

    public Mono<String> getArticles() {
        return this.client.get().uri("articles")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Tweet.class)
                .map(Tweet::content);
    }
}
