package ru.javarush.cryptoanalyzer.petrochenko.entity;


import ru.javarush.cryptoanalyzer.petrochenko.controller.Commands;


public class Result {

    public Result() {
        System.out.println("File" + Commands.parameters[0] + Commands.command + "to directory"+Commands.parameters[1]);

        }
}
