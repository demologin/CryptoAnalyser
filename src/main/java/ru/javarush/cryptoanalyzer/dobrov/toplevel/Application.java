package ru.javarush.cryptoanalyzer.dobrov.toplevel;

import ru.javarush.cryptoanalyzer.dobrov.entity.Result;
import ru.javarush.cryptoanalyzer.dobrov.controller.MainController;
import ru.javarush.cryptoanalyzer.dobrov.view.ConsoleRun;

@SuppressWarnings("ALL")
public class Application {
    private final ConsoleRun consoleRun;
    private final MainController mainController;

    public Application(ConsoleRun consoleRun, MainController mainController) {
        this.consoleRun = consoleRun;
        this.mainController = mainController;
    }

    public Result run() {
        //encode text.txt encoded.txt 45
//        String command = args[0];
//        String[] parameters = Arrays.copyOfRange(args, 1, args.length);

        consoleRun.runConsole();
        String command= consoleRun.getCommand();
        int key = consoleRun.getKey();

        return mainController.execute(command,key);
    }
}
