package ru.javarush.cryptoanalyser.osypenko.commands;

import ru.javarush.cryptoanalyser.osypenko.constants.ConstantText;
import ru.javarush.cryptoanalyser.osypenko.controller.QuestionExit;
import ru.javarush.cryptoanalyser.osypenko.controller.QuestionStart;
import ru.javarush.cryptoanalyser.osypenko.scan.Scan;
import ru.javarush.cryptoanalyser.osypenko.constants.Alphabet;
import ru.javarush.cryptoanalyser.osypenko.exception.ApplicationException;
import ru.javarush.cryptoanalyser.osypenko.util.PathFinder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Decrypt {
    public static void decrypt() {
        try {
            while (true) {
                System.out.println(ConstantText.ENTERTHEADDRESS);
                String scanRes = Scan.scan().nextLine();
                Path inPath;
                if (!scanRes.equals("")) {
                    if (scanRes.equalsIgnoreCase(ConstantText.EXIT)) {
                        System.out.println(ConstantText.GOODBYE);
                        break;
                    } else if (scanRes.equalsIgnoreCase(ConstantText.MENU)) {
                        QuestionStart.questionStart();
                        break;
                    }
                    inPath = Path.of(scanRes);
                } else {
                    inPath = Path.of(PathFinder.getRoot() + ConstantText.ENCRYPTNAMEFILE);
                }

                if (Files.exists(inPath)) {
                    FileInputStream fis = new FileInputStream(String.valueOf(inPath));
                    Reader reader = new InputStreamReader(fis);
                    BufferedReader bufferedReader = new BufferedReader(reader);
                    Writer writer = new FileWriter(inPath.getParent() + File.separator + ConstantText.DECRYPTNAMEFILE);

                    System.out.println(ConstantText.NUMBERKEYD);
                    String numKey = Scan.scan().nextLine();
                    if (numKey.equalsIgnoreCase(ConstantText.EXIT)) {
                        System.out.println(ConstantText.GOODBYE);
                        break;
                    } else if (numKey.equalsIgnoreCase(ConstantText.MENU)) {
                        QuestionStart.questionStart();
                        break;
                    }
                    int key = Integer.parseInt(numKey);

                    while (bufferedReader.ready()) {
                        char[] value = bufferedReader.readLine().toCharArray();
                        for (char c : value) {
                            for (int i = 0; i < Alphabet.fullAlphabet.length; i++) {
                                if (Alphabet.fullAlphabet[i] == c) {
                                    int res = (i - key) % Alphabet.fullAlphabet.length;
                                    if (res > 0) {
                                        writer.write(Alphabet.fullAlphabet[res]);
                                    } else {
                                        writer.write(Alphabet.fullAlphabet[Alphabet.fullAlphabet.length - Math.abs(res)]);
                                    }
                                }
                            }
                        }
                        writer.write(Alphabet.JUMP);
                    }
                    fis.close();
                    reader.close();
                    bufferedReader.close();
                    writer.close();
                    System.out.println("Выполнено! \nСоздан файл " + ConstantText.DECRYPTNAMEFILE + " по адресу " + inPath.getParent() + File.separator);

                    QuestionExit.questionExit();
                } else if (Files.isDirectory(inPath) || !Files.exists(inPath)) {
                    System.err.println(ConstantText.NOTENTEREDCORRECTY);
                    Decrypt.decrypt();
                }
                break;
            }
        } catch (IOException e) {
            throw new ApplicationException(e);
        }
    }
}
