package com.tech.capitole.challenge.exception.model;

public record ErrorResponse(
        String message,
        String details,
        String date) {
}
