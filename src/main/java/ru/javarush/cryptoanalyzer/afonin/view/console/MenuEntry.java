package ru.javarush.cryptoanalyzer.afonin.view.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuEntry {
    public String getTitle() {
        return title;
    }

    private final String title;
    private final String[][] questions;

    public MenuEntry(String title, String[][] questions) {
        this.title = title;
        this.questions = questions;
    }

    public String[] run(Scanner input){
        List<String> args = new ArrayList<>();
        args.add(questions[0][0]);
        for (int i = 1; i < questions.length; i++) {
            String[] question = questions[i];
            System.out.println(question[0] + question[1] + "): ");
            String inputParameters = input.nextLine();
            inputParameters = inputParameters.length() == 0 ? question[1] : inputParameters;
            args.add(inputParameters);
        }
        return args.toArray(new String[0]);
    }

}
