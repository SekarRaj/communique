package com.demo.communique.router;

import com.demo.communique.entity.Tweet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TweetRouterTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    @DisplayName("Route exists")
    public void testHello() {
        webTestClient.get()
                .uri("/articles")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Tweet.class)
                .value(tweet -> assertThat(tweet.content()).isEqualTo("Default response"));

    }
}