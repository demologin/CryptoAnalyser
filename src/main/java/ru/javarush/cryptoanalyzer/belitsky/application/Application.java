package ru.javarush.cryptoanalyzer.belitsky.application;

import ru.javarush.cryptoanalyzer.belitsky.manager.CommandManager;

public class Application {

    public static void run() {
        //TODO ---  message???
        while (true) {
            Menu.printMenu();
            Menu menuChoise = Menu.menuNavigation();
            if (menuChoise == Menu.EXIT) {
                System.out.println(Menu.END);
                break;
            }
            Menu.filePathCheck(menuChoise);
            CommandManager commandManager = new CommandManager(menuChoise);
            commandManager.runCommand();
            System.out.println(Menu.RESULT_AT + Menu.destination);
        }
        //TODO ---  message???

    }
}
