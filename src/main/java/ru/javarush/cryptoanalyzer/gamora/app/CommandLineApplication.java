package ru.javarush.cryptoanalyzer.gamora.app;

import ru.javarush.cryptoanalyzer.gamora.entity.Result;
import ru.javarush.cryptoanalyzer.gamora.entity.ResultCode;
import ru.javarush.cryptoanalyzer.gamora.exception.CryptoanalyzerApplicationException;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.util.Scanner;

public class CommandLineApplication extends Application {
    private final InputStream inputStream;
    private final Localization localization;

    public CommandLineApplication(PrintStream printStream, InputStream inputStream, String localizationCode) {
        super(printStream);
        this.inputStream = inputStream;
        this.localization = Localizations.valueOf(localizationCode).localization;
    }

    @Override
    public void run() {
        messageStream.println(localization.getStartMessage());
        Result execute = new Result(ResultCode.OK);
        do {
            try {
                Scanner scanner = new Scanner(inputStream);
                String[] args = scanner.nextLine().split(" ");
                this.controller = getController(args);
                execute = controller.execute(args[0], args);
                if (execute.resultCode == ResultCode.OK) {
                    messageStream.println(localization.getSuccessMessage(execute.actions));
                } else if (execute.resultCode == ResultCode.ERROR) {
                    messageStream.println(localization.getFailMessage(execute.actions));
                }
            } catch (CryptoanalyzerApplicationException e) {
                messageStream.println(e.getMessage());
            }
        } while (execute.resultCode != ResultCode.DONE);
    }
}
