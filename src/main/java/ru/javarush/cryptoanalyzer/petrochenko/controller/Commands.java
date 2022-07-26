package ru.javarush.cryptoanalyzer.petrochenko.controller;

import ru.javarush.cryptoanalyzer.petrochenko.Util.PathChoice;
import ru.javarush.cryptoanalyzer.petrochenko.commands.BroodForce;
import ru.javarush.cryptoanalyzer.petrochenko.commands.DecoderOne;
import ru.javarush.cryptoanalyzer.petrochenko.commands.EncoderOne;
import ru.javarush.cryptoanalyzer.petrochenko.constants.Messeges;

import java.io.IOException;
import java.util.Scanner;

public class Commands {
    public static String[] parameters;


    public static String command;


    public Commands() throws IOException {
        // PathChoice pathChoice = new PathChoice();
        Scanner console = new Scanner(System.in);
        int value;
        do {
            System.out.println(Messeges.selectOperation);
            value = Integer.parseInt(console.nextLine());
            command = String.valueOf(value);
        } while (value < 1 || value > 4);


        if (command.equals("1")) {
            System.out.print("Enter key: ");
            String key = console.nextLine();
            parameters = new String[]{String.valueOf(PathChoice.txtPath), String.valueOf(PathChoice.encryptedPath), key};
        } else if (command.equals("2")) {
            System.out.print("Enter key: ");
            String key = console.nextLine();
            parameters = new String[]{String.valueOf(PathChoice.encryptedPath), String.valueOf(PathChoice.decryptedPath), key};
        } else if (command.equals("3")) {
            String key = "0";
            parameters = new String[]{String.valueOf(PathChoice.encryptedPath), String.valueOf(PathChoice.decodedPath), key};
        }


        if (command.equals("1")) {
            new EncoderOne(parameters);
        } else if (command.equals("2")) {
            new DecoderOne(parameters);
        } else if (command.equals("3")) {
            new BroodForce(parameters);
        } else if (command.equals("4")) {
            System.out.println("Exit");
            return;
        }


    }

}

