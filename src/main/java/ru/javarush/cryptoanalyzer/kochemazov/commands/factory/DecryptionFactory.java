package ru.javarush.cryptoanalyzer.kochemazov.commands.factory;
import ru.javarush.cryptoanalyzer.kochemazov.commands.Command;
import ru.javarush.cryptoanalyzer.kochemazov.commands.Decryption;
public class DecryptionFactory implements CommandsFactory{
    @Override
    public Command createCommands() {
        return new Decryption();
    }
}
