package ru.javarush.cryptoanalyzer.osypenko.controller;

import ru.javarush.cryptoanalyzer.osypenko.constants.ConstantText;
import ru.javarush.cryptoanalyzer.osypenko.scan.Scan;

public class QuestionExit {
    public static void questionExit() {
        System.out.print("-".repeat(80));
        //TODO Coding. Magic values or methods. Bad reading and understanding
        String textQuestion = """
                \nВыберете команду которую Вы хотите выполнить?\s
                menu - что бы Продолжить\s
                exit - что бы Выйти\s
                \nДля выбора введите соответствующую команду""";
        //TODO Coding. We see console (System.out.print) here. Need move the output to View layer
        System.out.println(textQuestion);
        System.out.println("-".repeat(80));
        while (true) {
            String numberFunction = Scan.scan().next();
            if (numberFunction.equalsIgnoreCase(ConstantText.MENU)) {
                QuestionStart.questionStart();
                break;
            } else if (numberFunction.equalsIgnoreCase(ConstantText.EXIT)) {
                System.out.println(ConstantText.GOODBYE);
                break;
            } else {
                System.err.println(ConstantText.NOTECORRECTY);
            }
        }
    }
}
