package ru.javarush.cryptoanalyzer.marzhiievskyi.constants;

import java.util.ArrayList;
import java.util.List;

public class Strings {
    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    private static final String CYRILLIC_ALPHABET = "йцукенгшщзхъфывапролджэячсмитьбюё";
    private static final String NUMERIC = "0123456789";
    private static final String SYMBOLS = "-.,?'\";:! ";

    private static final String ALL_SYMBOLS =
            CYRILLIC_ALPHABET + CYRILLIC_ALPHABET.toUpperCase() + NUMERIC + SYMBOLS;

    public static final List<Character> ALPHABET_LIST = new ArrayList<>();

    static {
        for (Character ch : ALL_SYMBOLS.toCharArray()) {
            ALPHABET_LIST.add(ch);
        }
    }
    //TODO Code style. User russian comments? Bad English is much better than the best Russian comments.
    //Сообщения, которые использует программа
    private static final String EXIT_WORD = ANSI_GREEN + "exit" + ANSI_RESET;
    public static final String WELCOME_MESSAGE = ANSI_BLUE + "\nДобро пожаловать в Шифр Цезаря. Выберете и введите номер команды, " +
            "или слово " + EXIT_WORD + ANSI_BLUE + " для выхода из программы." + ANSI_RESET;

    public static final String CHOSE_COMMAND = ANSI_CYAN + """

            Выберете действие :\s
            Введите 1 чтобы зашифровать текст из файле
            Введите 2 чтобы расшифровать текст из зашифрованного
            Введите 3 чтобы расшифровать методом Brute Force
            Введите 4 чтобы попробовать расшифровать статистическим анализом""" + ANSI_RESET;
    public static final String ENTER_KEY_SHIFT = ANSI_PURPLE + "Введите цифру-ключ шифрования" + ANSI_RESET;
    public static final String ENTER_ENCRYPTED_TEXT_FILE = ANSI_PURPLE + "Введите имя файла, на котором зашифрован текст" + ANSI_RESET;
    public static final String ENTER_INPUT_FILE_TEXT = ANSI_PURPLE + "Введите имя файла с текстом для шифрования" + ANSI_RESET;
    public static final String ENTER_OUT_FILE_NAME = ANSI_PURPLE + "Введите имя файла, в котором будет результат" + ANSI_RESET;
    public static final String ENTER_INPUT_DICTIONARY_TEXT_FILE = ANSI_PURPLE + "Введите имя файла, в котором текст того же автора, для анализа" + ANSI_RESET;
    public static final String GOOD_BYE = ANSI_GREEN + "До свидания" + ANSI_RESET;
    public static final String IO_EXCEPTION_MSG = ANSI_RED + "Ошибка пути файла" + ANSI_RESET;
    public static final String ARGS_EXCEPTION_MSG = ANSI_RED + "Некорректно заданы аргументы" + ANSI_RESET;
    public static final String KEY_EXCEPTION_MSG = ANSI_RED + "Значение ключа не может быть '0', или отрицательным" + ANSI_RESET;
}
