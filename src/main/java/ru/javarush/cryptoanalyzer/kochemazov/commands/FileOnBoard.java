package ru.javarush.cryptoanalyzer.kochemazov.commands;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
public class FileOnBoard implements Command {
    private static Path pathInput;
    public static String getReadLineString() {
        return ReadLineString;
    }
    private static String ReadLineString;
    private static final Scanner scanner = new Scanner(System.in);
    @Override
    public void execute() throws IOException {
        while (true) {
            System.out.println("Пожалуйста введите путь к файлу");
            //TODO Code style. Need always delete code. Not comment it.
//            System.out.println("Если нужно выйте введите exit");
            String inputString = scanner.nextLine();
            Path newPath = Path.of(inputString);
            if (Files.exists(newPath)) {
                System.out.println("Файл загружен!");
                FileOnBoard.pathInput = newPath;
                FileOnBoard.ReadLineString = String.valueOf(Files.readAllLines(FileOnBoard.pathInput));
                break;
                //TODO Code style. Need always delete code. Not comment it.
//            } else if ("exit".equalsIgnoreCase(String.valueOf(newPath))) {
//                System.out.println("Досвиданья!");
//                break;
            } else {
                System.out.println("Файл не найден");
            }
        }
    }
    @Override
    public void execute(String input, int bias) {
        throw new UnsupportedOperationException("needs refactor");
    }
}
