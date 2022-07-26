package ru.javarush.cryptoanalyzer.kochemazov.commands.factory;
import ru.javarush.cryptoanalyzer.kochemazov.commands.Command;
import ru.javarush.cryptoanalyzer.kochemazov.commands.Encryption;
public class EncryptionFactory implements CommandsFactory{
    @Override
    public Command createCommands() {
        return new Encryption();
    }
}
