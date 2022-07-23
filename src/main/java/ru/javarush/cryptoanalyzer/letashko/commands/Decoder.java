package ru.javarush.cryptoanalyzer.letashko.commands;

import ru.javarush.cryptoanalyzer.letashko.entity.Result;

public class Decoder implements Action {
    private static String getCodingIncodMessage(String message, int key) {
        StringBuilder strBox = new StringBuilder(message.length());
        char tmp;
        for (int i = 0; i < message.length(); i++) {
            tmp = message.charAt(i);
            if (Character.isLetter(message.charAt(i))) {
                tmp += key % 26;
                if (tmp > 'z')
                    tmp = (char)(tmp % 'z' + 'a' - 1);
                else if (tmp < 'a')
                    tmp = (char)(tmp + 26);
            }
            strBox.append(tmp);
        }
        return strBox.toString();
    }

    public static void main(String[] args) {
        String message = "";
        String codeMessage = getCodingIncodMessage(message, 14);
        System.out.println(message + " -> " + codeMessage);
        String deCodeMessage = getCodingIncodMessage(codeMessage, -14);
        System.out.println(codeMessage + " -> " + deCodeMessage);
    }

    @Override
    public Result execute(String[] parameters) {
        return null;
    }
}
