package ru.javarush.cryptoanalyzer.markov.application.controller;

import ru.javarush.cryptoanalyzer.markov.application.model.commands.Actions;
import ru.javarush.cryptoanalyzer.markov.application.model.commands.Action;
import ru.javarush.cryptoanalyzer.markov.application.model.Model;
import ru.javarush.cryptoanalyzer.markov.application.model.entity.Result;
import ru.javarush.cryptoanalyzer.markov.application.view.View;

import java.io.FileNotFoundException;
import java.nio.file.Path;

public class MainController implements Controller {

    private final Model repository;

    private final View ui;


    public MainController(Model repository, View ui) {
        this.repository = repository;
        this.ui = ui;
    }

    @Override
    public void execute() {
        requestFileName();
        Action action = requestCommand();
        Result result = action.execute(requestKey(), repository.readSourceText());
        repository.writeResult(result.getText());
    }

    protected void requestFileName()  {
        String intendedFile = ui.getFile();
        savePathFile(Path.of(intendedFile));
    }
    private void savePathFile(Path toFile) {
        try {
            repository.initializeSource(toFile);
        } catch (FileNotFoundException e) {
            ui.warnUser(e.getMessage());
        }
    }


    protected Action requestCommand() {
        return Actions.find(ui.getCommand());
    }

    protected int requestKey() {
        return Integer.parseInt(ui.getKey());
    }

}
