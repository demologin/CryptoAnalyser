package ru.javarush.cryptoanalyzer.markov.application.view;

public interface View {

     void execute();

     String getCommand();
     String getFile();

     String getKey();

     void warnUser(String message);

}
