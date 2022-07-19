package ru.javarush.cryptoanalyzer.karpiza.config;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.shell.jline.PromptProvider;

@Configuration
public class ShellConfig {
    @Bean
    public PromptProvider myPromptProvider() {
        return () -> new AttributedString("cesar-cypher:>", AttributedStyle.DEFAULT.foreground(AttributedStyle.YELLOW));
    }
}
