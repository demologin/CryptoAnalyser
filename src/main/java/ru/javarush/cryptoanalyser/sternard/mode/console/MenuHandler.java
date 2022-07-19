package ru.javarush.cryptoanalyser.sternard.mode.console;

import ru.javarush.cryptoanalyser.sternard.application.EActions;
import ru.javarush.cryptoanalyser.sternard.exceptions.HandlerExceptions;

import java.util.Scanner;

import static ru.javarush.cryptoanalyser.sternard.constant.language.English.*;

public class MenuHandler extends ConsoleMenu {

    public MenuHandler(Scanner scanner) {
        super(scanner);
    }

    public String[] returnParamsFromMenu() {
        String action = menuGetAction();
        if (action.equals(EActions.BRUTE_FORCE_DECRYPTION.name())) {
            return new String[]{action, menuGetSourceFileName(), menuGetDestinationFileName()};
        } else {
            return new String[]{action, menuGetSourceFileName(), menuGetDestinationFileName(), menuGetKey()};
        }
    }

    protected String menuGetAction() {
        try {
            return switch (Integer.parseInt(scanner.nextLine())) {
                case 1 -> EActions.ENCRYPTION.name();
                case 2 -> EActions.KEY_DECRYPTION.name();
                case 3 -> EActions.BRUTE_FORCE_DECRYPTION.name();
                default -> throw new HandlerExceptions(WRONG_PARAMETERS);
            };
        } catch (NumberFormatException e) {
            throw new HandlerExceptions(WRONG_PARAMETERS, e.getStackTrace());
        }
    }

    protected String menuGetSourceFileName() {
        System.out.println(SOURCE_FILE_NAME);
        return scanner.nextLine();
    }

    protected String menuGetDestinationFileName() {
        System.out.println(DESTINATION_FILE_NAME);
        return scanner.nextLine();
    }

    protected String menuGetKey() {
        System.out.println(ENTER_KEY);
        return scanner.nextLine();
    }

}