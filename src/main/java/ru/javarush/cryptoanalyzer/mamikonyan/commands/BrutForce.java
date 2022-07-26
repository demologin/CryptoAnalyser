package ru.javarush.cryptoanalyzer.mamikonyan.commands;


import static ru.javarush.cryptoanalyzer.mamikonyan.constants.Constants.ALPHABET;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class BrutForce implements Action {

  @Override
  public void execute(String[] parameters) {
    String sourceFileName = parameters[0];
    for (int i = 0; i < ALPHABET.length(); i++) {
      String shiftedAlphabet = ALPHABET.substring(ALPHABET.length() - i) + ALPHABET.substring(0, ALPHABET.length() - i);
      int[] freq = new int[shiftedAlphabet.length()];

      try (BufferedReader br = new BufferedReader(new FileReader(sourceFileName))) {
        while (br.ready()) {
          String line = br.readLine();
          for (int j = 0; j < line.length(); j++) {
            char curr = line.charAt(j);
            char currShifted = ALPHABET.charAt(shiftedAlphabet.indexOf(curr));
            freq[shiftedAlphabet.indexOf(currShifted)]++;
          }
        }

        if (freq[shiftedAlphabet.indexOf(' ')] == Arrays.stream(freq).max().getAsInt()) {
          Encoder encoder = new Encoder();
          encoder.execute(new String[]{String.valueOf(i), parameters[0], parameters[1]});
        }

      } catch (IOException e) {
        e.printStackTrace();
      }
    }

  }
}
