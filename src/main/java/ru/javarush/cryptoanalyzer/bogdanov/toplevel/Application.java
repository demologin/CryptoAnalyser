package ru.javarush.cryptoanalyzer.bogdanov.toplevel;

import ru.javarush.cryptoanalyzer.bogdanov.entity.Result;
import ru.javarush.cryptoanalyzer.bogdanov.controller.MainController;
import ru.javarush.cryptoanalyzer.bogdanov.exeptions.ApplicationExeption;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Scanner;

public class Application {
    private final MainController maincontroller;

    public Application(MainController maincontroller) {
        this.maincontroller = maincontroller;
    }

   public String[] parametrs = new String[3];

    public Result run(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" 1.Decoder \n 2 Encoder \n 3 BruteForce \n 4 Statistics");
        int oper = Integer.parseInt(scanner.nextLine());
        String operation = choiceOperation(oper);
        System.out.println("Enter the file to be processed");
        String pathOfFileFrom = scanner.nextLine();
        System.out.println("File where to put the finished text");
        String pathOfFileTo = scanner.nextLine();
        System.out.println("File step for encoding and decoding");
        String step = scanner.nextLine();


        if (Objects.equals(operation, "")) {
            operation = args[0];
        }
        checkSourspathOnExists(pathOfFileFrom,args);
        checkLastpathOnExist(pathOfFileTo,args);
        checkStep(step,args);
        return this.maincontroller.execute(operation, parametrs);
    }

    public String choiceOperation(int i) {
        return switch (i) {
            case 1 -> "decoder";
            case 2 -> "encoder";
            case 3 -> "bruteforce";
            case 4 -> "statistics";
            default -> throw new ApplicationExeption("Unexpected value: " + i);
        };
    }

    public boolean checkIsNumberStep(String string) {
        int intValues;
        try {
            intValues = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public void checkSourspathOnExists(String pathOfFileFrom,String[] args){
        //Path path = Path.of(pathOfFileFrom);
        File file = new File(pathOfFileFrom);
        if(file.exists()){
            parametrs[0]=pathOfFileFrom;
        }else if (pathOfFileFrom.equals("")){
            parametrs[0]=args[1];
        }else{
            throw new ApplicationExeption("Source file does not exist");
        }
    }
    public void checkLastpathOnExist(String pathOfFileTo,String[] args){
        File file = new File(pathOfFileTo);
        if(file.exists()){
            parametrs[1]=pathOfFileTo;
        }else if (pathOfFileTo.equals("")) {
            parametrs[1]=args[2];
        }else{
            throw new ApplicationExeption("No last file");
        }
    }
    public void checkStep(String step,String[] args){
        if (!step.equals("") && checkIsNumberStep(step)){//(checkIsNumberStep(step) && Integer.parseInt(step) >= 0
            parametrs[2] = step;
        } else if (!checkIsNumberStep(step)) {
            parametrs[2] = args[3];
        }else {
            throw new ApplicationExeption("Enter the positiv number");
        }
    }
}

