package ru.javarush.cryptoanalyzer.karpiza.service;

import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

@Service
public class FileService {

    public String readFile(String source) throws IOException {
        try (FileInputStream reader = new FileInputStream(source)) {
            return new String(reader.readAllBytes(), StandardCharsets.UTF_8);
        }
    }

    public void writeFile(String text, String target) throws IOException {
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(target), StandardCharsets.UTF_8)) {
            writer.write(text);
        }
    }
}
