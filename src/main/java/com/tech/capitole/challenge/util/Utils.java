package com.tech.capitole.challenge.util;

import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Configuration
public class Utils {

    private static final DateTimeFormatter formatterInput = DateTimeFormatter.ofPattern("yyyy-M-d-H.m.s");
    public static final DateTimeFormatter formatterOutput = DateTimeFormatter.ofPattern("E, dd MMMM yyyy HH:mm:ss z")
            .withZone(ZoneId.of("Europe/Madrid"));

    public static String formatDate(String date) {
        LocalDateTime localDateTime = (Objects.nonNull(date)) ? LocalDateTime.parse(date, formatterInput) : LocalDateTime.now();
        return localDateTime.format(formatterOutput);
    }

}
