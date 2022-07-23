package ru.javarush.cryptoanalyzer.torkel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Main {

    public final static int EXIT = 0;
    public final static int ENCRYPT = 1;
    public final static int DECRYPT = 2;
    public final static int BRUTFORCE = 3;

    public static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    public static final String often100WordsFileName = "vocabulary_100.txt";
    public static final Set<Pattern> often100Words = new HashSet<>();

    public static void main(String[] args) {
        System.out.println("Шифрование.");
        init();
        main();
        System.out.println(PathFinder.getRoot());
    }
    public static void main() {
        //TODO Code style. Long code. Needs to be split into several methods
        Decoder decoder = new Decoder();
        while (true) {
            printMenu();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                //noinspection UnusedAssignment
                int cmdNumber = -1;
                try {
                    cmdNumber = Integer.parseInt(reader.readLine());
                } catch (NumberFormatException nfe) {
                    System.out.println("некорректный ввод, ожидается: 0, 1, 2, 3");
                    continue;
                }
                switch (cmdNumber) {
                    case Main.EXIT -> System.exit(0);
                    case Main.ENCRYPT, Main.DECRYPT -> {
                        System.out.println("Введите ключ для шифрования (число):");
                        int keyInt;
                        try {
                            keyInt = Integer.parseInt(reader.readLine());
                        } catch (NumberFormatException nfe) {
                            System.out.println("некорректный ввод, ожидается число");
                            continue;
                        }
                        if (Main.ENCRYPT == cmdNumber) {
                            decoder.encrypt("file_to_encrypt.txt", "encrypted_file.txt", keyInt);
                        } else {
                            decoder.encrypt("encrypted_file.txt", "decrypted_file.txt", -keyInt);
                        }
                    }
                    case Main.BRUTFORCE -> {
                        int key = decoder.brutForce();
                        System.out.println("вероятный ключ шифрования: " + key);
                    }
                }
            } catch (IOException | URISyntaxException e) {
                System.out.println("проблема возникла: " + e.getMessage());
                throw new RuntimeException(e);
            } catch (NumberFormatException nfe) {
                System.out.println("некорректный ввод, ожидается: 0, 1, 2, 3");
            }
        }
    }

    private static void init() {
        Path inputFilePath = Path.of(PathFinder.getRoot()+"vocabulary_100.txt");
        try (BufferedReader br = Files.newBufferedReader(inputFilePath)) {
            String oftenWord;
            while ((oftenWord = br.readLine()) != null) {
                often100Words.add(Pattern.compile("\\b" + oftenWord + "\\b"));
            }
        } catch (IOException e) {
            System.out.println("Проблема с чтением файла " + often100WordsFileName);
        }
    }

    private static void printMenu() {
        System.out.println("Menu:");
        System.out.println("1 - зашифровать");
        System.out.println("2 - расшифровать");
        System.out.println("3 - подбор пароля");
        System.out.println("0 - выход");
    }
}