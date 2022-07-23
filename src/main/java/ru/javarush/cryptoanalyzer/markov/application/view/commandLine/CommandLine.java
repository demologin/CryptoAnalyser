package ru.javarush.cryptoanalyzer.markov.application.view.commandLine;


import ru.javarush.cryptoanalyzer.markov.application.view.View;

public class CommandLine implements View {

    private final String[] argsCommandLine;

    public CommandLine(String[] args) {
        argsCommandLine = args;
    }

    /**
     *
     */
    @Override
    public void execute() {
        System.out.println("| Crypto Analyzer |");
        System.out.println("Press any key or type \"Exit\"");

        System.out.println("Launch Arguments: ");
        System.out.println("Command: " + getCommand());
        System.out.println("Path to source file: " + getFile());
        System.out.println("Key: " + getKey());
    }

    @Override
    public String getCommand() {
        return argsCommandLine[0];
    }

    @Override
    public String getFile() {
        return argsCommandLine[1];
    }

    @Override
    public String getKey() {
        return argsCommandLine[2];
    }

    @Override
    public void warnUser(String message) {
        System.out.println("message");
    }

}
