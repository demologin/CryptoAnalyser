package ru.javarush.cryptoanalyzer.sternard.controller;

import ru.javarush.cryptoanalyzer.sternard.application.Application;
import ru.javarush.cryptoanalyzer.sternard.mode.swing.RunnerGUI;

import java.util.Scanner;

import static ru.javarush.cryptoanalyzer.sternard.constant.language.English.*;
import static ru.javarush.cryptoanalyzer.sternard.util.ConsoleColors.*;

public class Controller {
    final Application application = new Application();

    public void run(String[] args) {
        if (args.length > 0 && args.length <= 4) {
            application.runWithArgs(args);
        } else {
            System.out.println(CYAN_BOLD + GUI_OR_CONSOLE + RESET);
            Scanner scan = new Scanner(System.in);
            String GUIorConsole = scan.nextLine();

            if (GUIorConsole.equalsIgnoreCase(GUI)) {
                new RunnerGUI().runGUI();
            } else if (GUIorConsole.equalsIgnoreCase(CONSOLE)) {
                application.runWithConsole(scan);
            } else {
                System.out.println(RED_BRIGHT + WRONG_PARAMETERS + RESET);
            }
        }
    }
}