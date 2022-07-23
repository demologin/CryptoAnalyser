package ru.javarush.cryptoanalyzer.markov.application.model;

import ru.javarush.cryptoanalyzer.markov.application.controller.exeption.FileEmptyException;
import ru.javarush.cryptoanalyzer.markov.application.controller.exeption.IOApplicationException;
import ru.javarush.cryptoanalyzer.markov.application.util.PathFinder;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileSystem implements Model {

    private Path toSourceFile = null;

    private final Path toResultFile;

    public FileSystem() {
        toResultFile = Path.of(PathFinder.getRoot() + "result.txt");
    }

    public Path getToSourceFile() {
        return toSourceFile;
    }

    public Path getToResultFile() {
        return toResultFile;
    }

    @Override
    public List<Character> getResult() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Character> readSourceText() {
        ArrayList<Character> text = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(getToSourceFile().toFile()))) {
            int letter;
            while ((letter = reader.read()) != -1) {
                text.add((char)letter);
            }
        } catch (IOException e) {
            throw new IOApplicationException(e);
        }
        return text;
    }

    @Override
    public void writeResult(List<Character> text) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(getToResultFile().toFile()));
            for (Character symbol : text) {
                writer.write(symbol);
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new IOApplicationException(e);
        }
    }

    @Override
    public void initializeSource(Path transferredFile) throws FileNotFoundException, FileEmptyException {
        if(!isExists(transferredFile)) {
            Path path = Path.of(PathFinder.getRoot() + transferredFile);
            if(isEmpty(path)) {
                toSourceFile = path;
            } else {
                throw new FileEmptyException();
            }
        } else {
            throw new FileNotFoundException();
        }
    }
    private boolean isExists(Path path) {
        return path.toFile().exists();
    }
    private boolean isEmpty(Path path) {
        return path.toFile().length() != 0;
    }

}
