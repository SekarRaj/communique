package com.demo.communique.router;

import com.demo.communique.handler.TweetHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicate;

import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class TweetRouter {

    @Bean
    public RouterFunction<ServerResponse> route(TweetHandler tweetHandler) {
        RequestPredicate predicate = GET("/articles").and(accept(MediaType.APPLICATION_JSON));
        return RouterFunctions
                .route(predicate, tweetHandler::articles);

    }
}
