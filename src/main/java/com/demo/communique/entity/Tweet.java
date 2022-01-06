package com.demo.communique.entity;

import java.util.UUID;

public record Tweet(UUID id, String content) {
}
