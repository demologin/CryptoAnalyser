package ru.javarush.cryptoanalyzer.stepin.controller;

import ru.javarush.cryptoanalyzer.stepin.commands.BruteForse;
import ru.javarush.cryptoanalyzer.stepin.commands.Decoder;
import ru.javarush.cryptoanalyzer.stepin.commands.Encoder;
import ru.javarush.cryptoanalyzer.stepin.commands.StaticDecrypt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainController {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public MainController() {
        try {
            while (true) {
                System.out.println("""

                        Выберете действие, введя его номер:\s
                        1. Зашифровать текст в файле с помощью ключа.\s
                        2. Расшифровать текст в файле с помощью ключа.\s
                        3. Подобрать ключ к зашифрованому тексу в файле (brute force).\s
                        4. Расшифровать текст в файле методом статического перебора.\s

                        Для выхода из программы введите exit""");

                String answer = reader.readLine();

                switch (answer) {
                    case ("1") -> new Encoder().execute();
                    case ("2") -> new Decoder().execute();
                    case ("3") -> new BruteForse().execute();
                    case ("4") -> new StaticDecrypt().execute();
                }
                if (answer.equals("exit")) {
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода");
        }
    }
}
