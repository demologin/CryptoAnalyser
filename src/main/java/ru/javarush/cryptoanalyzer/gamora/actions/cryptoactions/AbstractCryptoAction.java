package ru.javarush.cryptoanalyzer.gamora.actions.cryptoactions;

import ru.javarush.cryptoanalyzer.gamora.actions.basicactions.AbstractAction;
import ru.javarush.cryptoanalyzer.gamora.entity.Result;
import ru.javarush.cryptoanalyzer.gamora.exception.CryptoanalyzerApplicationException;
import ru.javarush.cryptoanalyzer.gamora.util.PathFinder;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractCryptoAction extends AbstractAction {
    protected final Path dictPath = PathFinder.pathFinder.getFilePath("dict.txt");
    protected Map<Character, Character> map;

    @Override
    protected void writeResult() {
        super.writeResult();
        writeDictionary();
    }

    private void writeDictionary() {
        try (FileWriter fileWriter = new FileWriter(dictPath.toFile())) {
            fileWriter.write(map.toString().toCharArray());
        } catch (IOException e) {
            throw new CryptoanalyzerApplicationException(e);
        }
    }

    protected String getTextAlphabet(String text) {
        Set<Character> characterSet = new HashSet<>();
        for (int i = 0; i < text.length(); i++) {
            Character character = text.charAt(i);
            characterSet.add(character);
        }
        char[] chars = new char[characterSet.size()];
        int i = 0;
        for (Character character : characterSet) {
            chars[i++] = character;
        }
        return new String(chars);
    }

    @Override
    public void build(String[] args) {
        readPath = PathFinder.pathFinder.getFilePath(args, 1);
        writePath = PathFinder.pathFinder.getFilePath(args, 2);
        currentText = readFromFile(readPath);
    }
}
