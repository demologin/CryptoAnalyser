package ru.javarush.cryptoanalyzer.belitsky.manager;

import ru.javarush.cryptoanalyzer.belitsky.actions.mainActions;
import ru.javarush.cryptoanalyzer.belitsky.actions.Actions2;
import ru.javarush.cryptoanalyzer.belitsky.application.Menu;

public class CommandManager {

    private final Menu option;

    public CommandManager(Menu option) {
        this.option = option;
    }

    public void runCommand() {

        switch (option) {
            case ENCRYPT -> Actions2.rollWithKey(Menu.source, Menu.destination, Menu.inputKey());
            case DECRYPT_WITH_KEY -> mainActions.decryptWithKey(Menu.source, Menu.destination);
            case DECRYPT_BRUTFORCE -> mainActions.decryptBrutForce(Menu.source,Menu.destination);
            case DECRYPT_STATISTIC -> mainActions.decryptStatic(Menu.standartOrig,Menu.source,Menu.destination);
            default -> throw new IllegalStateException("Unexpected value: " + option);
        }
    }

}
