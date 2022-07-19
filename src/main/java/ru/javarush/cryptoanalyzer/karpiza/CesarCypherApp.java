package ru.javarush.cryptoanalyzer.karpiza;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class CesarCypherApp {

    public static void main(String[] args) {

        SpringApplication.run(CesarCypherApp.class, args);
    }
}
