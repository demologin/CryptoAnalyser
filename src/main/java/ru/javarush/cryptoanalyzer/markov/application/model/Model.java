package ru.javarush.cryptoanalyzer.markov.application.model;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.List;

public interface Model {


    void initializeSource(Path toFile) throws FileNotFoundException;

     List<Character> readSourceText();

     void writeResult(List<Character> text);

     List<Character> getResult();

}
