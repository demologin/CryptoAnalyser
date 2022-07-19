package ru.javarush.cryptoanalyser.sternard.application;

import ru.javarush.cryptoanalyser.sternard.exceptions.HandlerExceptions;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static ru.javarush.cryptoanalyser.sternard.constant.language.English.*;

public class ReaderWriter {

    public String reader(String fileName) {
        StringBuilder text = new StringBuilder();
        Path path = Path.of(fileName);
        if (Files.exists(path)) {
            try (BufferedReader buff = new BufferedReader(new FileReader(fileName))) {
                while (buff.ready()) {
                    text.append((char) buff.read());
                }
                return text.toString();
            } catch (IOException e) {
                throw new HandlerExceptions(FILE_READING_ERROR, e.getStackTrace());
            }
        } else {
            throw new HandlerExceptions(FILE_NOT_FOUND_ERROR);
        }
    }

    public boolean writer(String fileName, String text, boolean append) {
        Path path = Path.of(fileName);
        if (Files.notExists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                throw new HandlerExceptions(FILE_CREATE_ERROR, e.getStackTrace());
            }
        }
        try (BufferedWriter buff = new BufferedWriter(new FileWriter(fileName, append))) {
            buff.write(text);
        } catch (IOException e) {
            throw new HandlerExceptions(FILE_WRITING_ERROR, e.getStackTrace());
        }
        return true;
    }
}
