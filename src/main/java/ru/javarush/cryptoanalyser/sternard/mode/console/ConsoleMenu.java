package ru.javarush.cryptoanalyser.sternard.mode.console;

import java.util.Scanner;

import static ru.javarush.cryptoanalyser.sternard.constant.language.English.*;
import static ru.javarush.cryptoanalyser.sternard.util.ConsoleColors.*;

public abstract class ConsoleMenu {
    protected final Scanner scanner;

    public ConsoleMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void showMenu() {
        System.out.println(YELLOW_BRIGHT + "-".repeat(20) + RESET);
        System.out.printf(BLUE_BOLD_BRIGHT + "%s\n" + RESET + "%s\n%s\n%s\n", SELECT_MODE_MENU,
                BLUE_BOLD_BRIGHT + "1" + RESET + BLUE + ENCRYPT_WITH_KEY + RESET,
                BLUE_BOLD_BRIGHT + "2" + RESET + BLUE + DECRYPT_WITH_KEY + RESET,
                BLUE_BOLD_BRIGHT + "3" + RESET + BLUE + BRUTE_FORCE_DECRYPTION + RESET);
        System.out.println(YELLOW_BRIGHT + "-".repeat(20) + RESET);
    }

    public abstract String[] returnParamsFromMenu();

    protected abstract String menuGetAction();

    protected abstract String menuGetSourceFileName();

    protected abstract String menuGetDestinationFileName();

    protected abstract String menuGetKey();
}