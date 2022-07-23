package ru.javarush.cryptoanalyzer.markov.application;

import ru.javarush.cryptoanalyzer.markov.application.controller.MainController;
import ru.javarush.cryptoanalyzer.markov.application.controller.Controller;
import ru.javarush.cryptoanalyzer.markov.application.model.FileSystem;
import ru.javarush.cryptoanalyzer.markov.application.view.commandLine.CommandLine;

public class Application {

    /*
    0 - команда
    1 - путь до исходного файла
    3 - ключ

    Какие ошибки заметил сам:

    1. Текстовый файл с результатом один, вшит. Исправить.
    2. Исключения не обрабатываются должным образом.
    3. Какие-то участки "просят" комментарии. Рефакторинг.
     */

    public void execute(String[] args) {
        Controller controller = new MainController(new FileSystem(), new CommandLine(args));
        controller.execute();
    }

}
