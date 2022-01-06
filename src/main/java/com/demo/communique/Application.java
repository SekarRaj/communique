package com.demo.communique;

import com.demo.communique.client.ArticleClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =  SpringApplication.run(Application.class, args);

		ArticleClient articleClient = context.getBean(ArticleClient.class);

		System.out.println(">> message : = " + articleClient.getArticles().block());
	}

}
