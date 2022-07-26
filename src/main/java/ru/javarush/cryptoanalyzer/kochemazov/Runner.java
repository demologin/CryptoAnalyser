package ru.javarush.cryptoanalyzer.kochemazov;
import ru.javarush.cryptoanalyzer.kochemazov.commands.Bias;
import ru.javarush.cryptoanalyzer.kochemazov.commands.Command;
import ru.javarush.cryptoanalyzer.kochemazov.commands.FileOnBoard;
import ru.javarush.cryptoanalyzer.kochemazov.commands.factory.*;

import java.io.IOException;
public class Runner {
    public static void main(String[] args) throws IOException {
        CommandsFactory commandsFactory = createCommandInline("1");
        Command command = commandsFactory.createCommands();
        command.execute();
        CommandsFactory commandsFactoryTwo = createCommandInline("2");
        Command commandTwo = commandsFactoryTwo.createCommands();
        commandTwo.execute();
        CommandsFactory commandsFactoryThree = createCommandInline("3");
        Command commandThree = commandsFactoryThree.createCommands();
        commandThree.execute(FileOnBoard.getReadLineString(), Bias.getKEY());

    }

    static CommandsFactory createCommandInline(String info){

        if(info.equalsIgnoreCase("1")){
            return new FileOnBoardFactory();
        }
        else if (info.equalsIgnoreCase("2")){
            return new BiasFactory();
        }
        else if (info.equalsIgnoreCase("3")){
            return new EncryptionFactory();
        }
        else if (info.equalsIgnoreCase("4")){
            return new DecryptionFactory();
        }
        else if (info.equalsIgnoreCase("5")){
            return new BruteForceFactory();
        }
        else {
            throw new RuntimeException("Нет такой команды");
        }
    }

}
