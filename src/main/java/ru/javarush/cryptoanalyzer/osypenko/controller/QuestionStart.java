package ru.javarush.cryptoanalyzer.osypenko.controller;

import ru.javarush.cryptoanalyzer.osypenko.constants.ConstantText;
import ru.javarush.cryptoanalyzer.osypenko.scan.Scan;
import ru.javarush.cryptoanalyzer.osypenko.commands.Analyze;
import ru.javarush.cryptoanalyzer.osypenko.commands.BruteForce;
import ru.javarush.cryptoanalyzer.osypenko.commands.Decrypt;
import ru.javarush.cryptoanalyzer.osypenko.commands.Encrypt;

public class QuestionStart {
    public static void questionStart() {
        System.out.println("-".repeat(80));
        String textQuestion = """
                Выберете функцию которую Вы хотите выполнить?\s
                1 - Шифровка текста\s
                2 - Расшифровка текста с помощью ключа\s
                3 - Расшифровка текста с помощью brute force (перебор всех вариантов)\s
                4 - Расшифровка с помощью статистического анализа текста
                exit - для выхода из программы. (на любом этапе выполнения программы) \s
                menu - для возврата в главное меню. (на любом этапе выполнения программы) \s
                \nДля выбора введите соответствующий номер функции""";
        System.out.println(textQuestion);
        System.out.println("-".repeat(80));
        questionRun();
    }

    public static void questionRun() {
        while (true) {
            String numberFunction = Scan.scan().next();
            if (numberFunction.equals("1")) {
                System.out.println("Вы выбрали Шифрование текста");
                Encrypt.encrypt();
                break;
            } else if (numberFunction.equals("2")) {
                System.out.println("Вы выбрали Дешифрование текста");
                Decrypt.decrypt();
                break;
            } else if (numberFunction.equals("3")) {
                System.out.println("Вы выбрали Расшифровка текста с помощью brute force (перебор всех вариантов)");
                BruteForce.bruteForce();
                break;
            } else if (numberFunction.equals("4")) {
                System.err.println("Извините но данная функция находится в разработке");
                Analyze.analyze();
                break;
            } else if (numberFunction.equalsIgnoreCase(ConstantText.EXIT)) {
                System.out.println(ConstantText.GOODBYE);
                break;
            } else if (numberFunction.equalsIgnoreCase(ConstantText.MENU)) {
                System.err.println("Вы уже находитесь в главном меню.");
            } else {
                System.err.println(ConstantText.NOTECORRECTY);
            }
        }
    }
}
