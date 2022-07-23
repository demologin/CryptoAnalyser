package ru.javarush.cryptoanalyzer.afonin.view.console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Scanner input;
    private final List<MenuEntry> entries = new ArrayList<>();

    public Menu(Scanner input) {
        this.input = input;
        addEntries();
    }

    public String[] run(){
        while (true){
            printMenu();
            String line = input.nextLine();
            int choice = Integer.parseInt(line);
            if (choice > entries.size() + 1) {
                continue;
            }

            MenuEntry entry = entries.get(choice - 1);
            return entry.run(input);
        }
    }

    private void addEntries(){
        for (String[][] command : Messages.QESTIONS) {
            entries.add(new MenuEntry(command[0][0], Arrays.copyOfRange(command, 1, command.length)));
        }
    }

    private void printMenu() {
        System.out.println(Messages.MENU_TITLE);
        for (int i = 0; i < entries.size(); i++) {
            System.out.println((i + 1) + ". " + entries.get(i).getTitle());
        }
    }
}