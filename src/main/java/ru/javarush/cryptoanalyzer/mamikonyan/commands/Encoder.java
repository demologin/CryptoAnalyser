package ru.javarush.cryptoanalyzer.mamikonyan.commands;

import static ru.javarush.cryptoanalyzer.mamikonyan.constants.Constants.ALPHABET;

public class Encoder implements Action {

  @Override
  public void execute(String[] parameters) {
    int key = Integer.parseInt(parameters[0]) % ALPHABET.length();
    String sourceFileName = parameters[1];
    String targetFileName = parameters[2];
    String shiftedAlphabet = ALPHABET.substring(ALPHABET.length() - key) + ALPHABET.substring(0, ALPHABET.length() - key);
    //TODO ---  need common place for codingText
    Decoder.codingText(sourceFileName, targetFileName, shiftedAlphabet);

  }
}
