package ru.javarush.cryptoanalyzer.kochemazov;
import ru.javarush.cryptoanalyzer.kochemazov.commands.*;
import ru.javarush.cryptoanalyzer.kochemazov.controller.ActionContainer;

import java.io.IOException;
import java.util.Scanner;
public class RunnerTwo {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите команду для выполнения:");
            System.out.println("0 - загрузить файл");
            System.out.println("1 - задать сдвиг");
            System.out.println("2 - шифрование");
            System.out.println("3 - разшифрование");
            System.out.println("4 - брутфорс");
            System.out.println("9 - выход");
            String input = scanner.nextLine();
            if (Integer.parseInt(input) > -1 && Integer.parseInt(input) < 2) {
                ActionContainer.find(input).execute();
            } else if (Integer.parseInt(input) == 2) {
                ActionContainer.find(input).execute(FileOnBoard.getReadLineString(), Bias.getKEY());
            } else if (Integer.parseInt(input) == 3) {
                ActionContainer.find(input).execute(Encryption.getOutput(), Bias.getKEY());
            } else if (Integer.parseInt(input) == 4) {
                ActionContainer.find(input).execute(Encryption.getOutput(), Bias.getKEY());
            } else if (Integer.parseInt(input) == 9) {
                System.out.println("Выход из программы");
                break;
            }
        }
    }
}
