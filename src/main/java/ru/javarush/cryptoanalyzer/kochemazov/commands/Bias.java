package ru.javarush.cryptoanalyzer.kochemazov.commands;
import java.io.IOException;
import java.util.Scanner;
public class Bias implements Command{
    private static int KEY = 0;
    private static final Scanner scanner = new Scanner(System.in);
    @Override
    public void execute() throws IOException {
        while (true) {
            //TODO Coding. We see console (System.out.print) here. Need move the output to View layer
            System.out.println("Пожалуйста, введите сдвиг");
            System.out.println();
            KEY = scanner.nextInt();
            if (KEY > 0 && KEY < 33) {
                System.out.println("Сдвиг добавлен");
                break;
            } else {
                System.out.println("Сдвиг задан не правильно!");
            }
        }
    }
    @Override
    public void execute(String input, int bias) {
        throw new UnsupportedOperationException("needs refactoring");
    }
    public static int getKEY() {
        return KEY;
    }
}
