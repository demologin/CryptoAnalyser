package ru.javarush.cryptoanalyzer.kochemazov.commands.factory;
import ru.javarush.cryptoanalyzer.kochemazov.commands.Command;
import ru.javarush.cryptoanalyzer.kochemazov.commands.FileOnBoard;
public class FileOnBoardFactory implements CommandsFactory{
    @Override
    public Command createCommands() {
        return new FileOnBoard();
    }
}
