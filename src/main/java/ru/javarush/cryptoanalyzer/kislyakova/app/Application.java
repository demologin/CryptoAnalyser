package ru.javarush.cryptoanalyzer.kislyakova.app;
import ru.javarush.cryptoanalyzer.kislyakova.entity.Result;
import ru.javarush.cryptoanalyzer.kislyakova.controller.MainController;

import java.util.Arrays;
@SuppressWarnings("ClassCanBeRecord")
public class Application {
    private final MainController mainController;

    public Application(MainController mainController) {
        this.mainController = mainController;
    }

    public Result run(String[] args) {
        //1arg = encode 2arg = text.txt 3arg = (where write res) encoded.txt 4arg = (key) 45
        String command = args[0]; //1arg = encode
        String[] parameters = Arrays.copyOfRange(args, 1, args.length); //params 2arg = text.txt 3arg = (where write res) encoded.txt 4arg = (key) 45
        return mainController.execute(command, parameters);
    }
}
