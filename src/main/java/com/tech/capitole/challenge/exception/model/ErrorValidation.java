package com.tech.capitole.challenge.exception.model;

import java.util.Map;

public record ErrorValidation(
        String message,
        Map<String, String> details,
        String date
) {
}
