package ru.javarush.cryptoanalyzer.kochemazov.commands;
import java.io.IOException;

public interface Command {
    default void execute() throws IOException {}
    void execute(String input, int bias);

}
