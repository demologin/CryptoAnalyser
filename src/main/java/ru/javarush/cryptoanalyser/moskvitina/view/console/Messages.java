package ru.javarush.cryptoanalyser.moskvitina.view.console;

import ru.javarush.cryptoanalyser.moskvitina.controller.Actions;

public interface Messages {
    String[][][] HEADERS = new String[][][] {
            {
                    {String.valueOf(Actions.ENCODE)},
                    {"Введи полный путь к исходному файлу или нажмите Enter для шифрования стандартного файла"},
                    {"Введите полный путь к конечному файлу (или имя) или нажмите Enter для стандартного пути зашифрованного файла"},
                    {"Введите ключ, например, 3 или нажмите Enter для стандартного значения ключа"}
            },

            {
                    {String.valueOf(Actions.DECODE)},
                    {"Введи полный путь к исходному файлу или нажмите Enter для дешифрования стандартного файла"},
                    {"Введите полный путь к конечному файлу (или имя) или нажмите Enter для стандартного пути дешифрованного файла"},
                    {"Введите ключ, например, 3 или нажмите Enter для стандартного значения ключа"}
            },

            {
                    {String.valueOf(Actions.BRUTEFORCE)},
                    {"Введи полный путь к исходному файлу или нажмите Enter для дешифрования стандартного файла"},
                    {"Введите полный путь к конечному файлу (или имя) или нажмите Enter для стандартного пути дешифрованного файла"}
            },

            {
                    {String.valueOf(Actions.EXIT)},
                    {"Выход"}
            }
    };

    String RESET = "\033[0m";

    String BLACK = "\033[0;30m";   // BLACK
    String RED = "\033[0;31m";     // RED
    String GREEN = "\033[0;32m";   // GREEN
    String YELLOW = "\033[0;33m";  // YELLOW
    String BLUE = "\033[0;34m";    // BLUE
    String PURPLE = "\033[0;35m";  // PURPLE
    String CYAN = "\033[0;36m";    // CYAN
    String WHITE = "\033[0;37m";   // WHITE
    String CYAN_BOLD = "\033[1;36m"; // CYAN BOLD
    String PURPLE_BOLD = "\033[1;35m"; // PURPLE BOLD

    String LINE = "-".repeat(20);

    String MESSAGE_SELECT_MODE = LINE +
            PURPLE_BOLD + "\nЧто вы хотите сделать:\n" + CYAN +
            "1. Зашифровать\n2. Дешифровать\n3. Взлом\n4. Выход\n" + RESET + LINE;

    String INCORRECT_SELECTION = RED + "\nЯ не могу это сделать. Попробуйте ещё раз.\n" + RESET ;

    String OK_FORMAT = GREEN + "Вроде сделаль. %s" + RESET;

    String ERR_FORMAT = RED + "Это была роковая ошибка, а именно: %s" + RESET;
}
