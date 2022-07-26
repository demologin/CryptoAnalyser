package ru.javarush.cryptoanalyzer.kochemazov.commands.factory;
import ru.javarush.cryptoanalyzer.kochemazov.commands.Bias;
import ru.javarush.cryptoanalyzer.kochemazov.commands.Command;
public class BiasFactory implements CommandsFactory {
    @Override
    public Command createCommands() {
        return new Bias();
    }
}
