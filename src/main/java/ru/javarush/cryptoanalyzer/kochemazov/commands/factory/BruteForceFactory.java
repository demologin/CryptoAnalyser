package ru.javarush.cryptoanalyzer.kochemazov.commands.factory;
import ru.javarush.cryptoanalyzer.kochemazov.commands.BruteForce;
import ru.javarush.cryptoanalyzer.kochemazov.commands.Command;
public class BruteForceFactory implements CommandsFactory {
    @Override
    public Command createCommands() {
        return new BruteForce();
    }
}
