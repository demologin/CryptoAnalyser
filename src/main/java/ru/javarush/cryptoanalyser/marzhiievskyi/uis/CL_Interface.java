package ru.javarush.cryptoanalyser.marzhiievskyi.uis;

import ru.javarush.cryptoanalyser.marzhiievskyi.constants.Strings;

import java.util.Scanner;

public class CL_Interface {
    public static String[] gettingUserParametersWithCL() {

        String[] parameters = new String[4];

        Scanner console = new Scanner(System.in);
        System.out.println(Strings.WELCOME_MESSAGE );
        System.out.println(Strings.CHOSE_COMMAND);

        String command = console.next();

        if (command.equalsIgnoreCase("exit")) {
            System.out.println(Strings.GOOD_BYE);
            System.exit(0);
        }

            switch (command) {
                case "1" -> {
                    parameters[0] = "encrypt";
                    System.out.println(Strings.ENTER_INPUT_FILE_TEXT);
                    parameters[1] = console.next();
                    System.out.println(Strings.ENTER_OUT_FILE_NAME);
                    parameters[2] = console.next();
                    System.out.println(Strings.ENTER_KEY_SHIFT);
                    parameters[3] = console.next();
                }
                case "2" -> {
                    parameters[0] = "decrypt";
                    System.out.println(Strings.ENTER_ENCRYPTED_TEXT_FILE);
                    parameters[1] = console.next();
                    System.out.println(Strings.ENTER_OUT_FILE_NAME);
                    parameters[2] = console.next();
                    System.out.println(Strings.ENTER_KEY_SHIFT);
                    parameters[3] = console.next();
                }
                case "3" -> {
                    parameters[0] = "bruteforce";
                    System.out.println(Strings.ENTER_ENCRYPTED_TEXT_FILE);
                    parameters[1] = console.next();
                    System.out.println(Strings.ENTER_OUT_FILE_NAME);
                    parameters[2] = console.next();
                }
                case "4" -> {
                    parameters[0] = "textanalyzer";
                    System.out.println(Strings.ENTER_ENCRYPTED_TEXT_FILE);
                    parameters[1] = console.next();
                    System.out.println(Strings.ENTER_OUT_FILE_NAME);
                    parameters[2] = console.next();
                    System.out.println(Strings.ENTER_INPUT_DICTIONARY_TEXT_FILE);
                    parameters[3] = console.next();
                }
            }

        return parameters;
    }
}
