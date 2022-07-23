package ru.javarush.cryptoanalyzer.cherepovskiy.view;

import ru.javarush.cryptoanalyzer.cherepovskiy.constants.Const;
import ru.javarush.cryptoanalyzer.cherepovskiy.exceptions.AppException;
import ru.javarush.cryptoanalyzer.cherepovskiy.util.PathFinder;

import java.util.Scanner;

public class Menu {
        Scanner scanner = new Scanner(System.in);


    public String[] getFromMenu(){
        int choice;
        String[] parametrs = new String[4];
        System.out.println(Const.menu);
        try  {
             choice = Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException e) {
            throw new AppException("Not a number please try again");
        }
        //TODO Code style. Use Russian comments? Bad English is much better than the best Russian comments.
// меню, по хорошему вынести все строки в интерфейс Const
        //TODO Code style. Needs reformat or extraction to methods / variables / constants
        switch (choice) {
            //TODO Code style. Long code. Needs to be split into several methods
            case 1 -> {
                parametrs[0] = "ENCRYPT";

                System.out.println("Enter original file (File name) or Press Enter for text.txt");
                String text = scanner.nextLine();
                if (text.equals("")) {
                    parametrs[1] = "text.txt";
                } else {
                    parametrs[1] = text;
                }
                System.out.println("Enter destination file (File name) or press Enter for encrypted.txt");
                String encrypted = scanner.nextLine();
                if (encrypted.equals("")) {
                    parametrs[2] = "encrypted.txt";
                } else {
                    parametrs[2] = encrypted;
                }
                System.out.println("Enter key - number or press Enter for key 5");
                String key = scanner.nextLine();
                if (key.equals("")) {
                    parametrs[3] = "5";
                } else {
                    parametrs[3] = key;
                }
            }
            case 2 -> {
                parametrs[0] = "DECRYPT";
                System.out.println("Enter the original encrypted file (File name) or Press Enter for encrypted.txt");
                String encrypted = scanner.nextLine();
                if (encrypted.equals("")) {
                    parametrs[1] = "encrypted.txt";
                } else {
                    parametrs[1] = encrypted;
                }
                System.out.println("Enter destination file (File name) or press Enter for decrypted.txt");
                String destination = scanner.nextLine();
                if (destination.equals("")) {
                    parametrs[2] = "decrypted.txt";
                } else {
                    parametrs[2] = destination;
                }
                System.out.println("Enter key - number or press Enter for key 5");
                String key = scanner.nextLine();
                if (key.equals("")) {
                    parametrs[3] = "5";
                } else {
                    parametrs[3] = key;
                }
            }
            case  3 -> {

                parametrs[0] = "BRUTEFORCE";
                System.out.println("Enter the original encrypted file (File name) or press Enter for encrypted.txt");
                String encrypted = scanner.nextLine();
                if (encrypted.equals("")) {
                    parametrs[1] = "encrypted.txt";
                } else {
                    parametrs[1] = encrypted;
                }
                System.out.println("Enter destination file (File name) or press Enter for bruteforce.txt");
                String destination = scanner.nextLine();
                if (destination.equals("")) {
                    parametrs[2] = "bruteforce.txt";
                } else {
                    parametrs[2] = destination;
                }
            }
            case 4 -> {
                parametrs[0] = "ANALYSE";
                System.out.println("Enter the original encrypted file (File name) or press Enter for encrypted.txt");
                String encrypted = scanner.nextLine();
                if (encrypted.equals("")) {
                    parametrs[1] = "encrypted.txt";
                } else {
                    parametrs[1] = encrypted;
                }
                System.out.println("Enter the original decrypted file(File name) or press Enter for dictionary.txt");
                String dictionary = scanner.nextLine();
                if (dictionary.equals("")) {
                    parametrs[2] = "dictionary.txt";
                } else {
                    parametrs[2] = dictionary;
                }
                System.out.println("Enter the destination file(File name) or press Enter for analysed.txt");
                String analysed = scanner.nextLine();
                if (analysed.equals("")) {
                    parametrs[3] = "analysed.txt";
                } else {
                    parametrs[3] = analysed;
                }
            }
            case 5 -> parametrs[0] = "EXIT";
            default -> throw new AppException("Unexpected value: " + choice);
        }
        scanner.close();
        return parametrs;

    }

}
