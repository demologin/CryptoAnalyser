package ru.javarush.cryptoanalyzer.kislyakova.view.console;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import static ru.javarush.cryptoanalyzer.kislyakova.view.console.Messages.*;

@SuppressWarnings("ClassCanBeRecord")
public class Menu {
    private final Scanner scanner;

    public Menu(Scanner scanner){
        this.scanner = scanner;
    }

    public String[] getArgs(){
        int action = getAction(scanner);
        String[] args = new String[QUESTIONS[action].length];
        args[0] = QUESTIONS[action][0][0];
        for (int i = 1; i < args.length; i++){
            String quest = QUESTIONS[action][i][0];
            String answer;
            if(quest.contains("Укажите путь к файлу")){
                answer = getFilePath(quest);
            } else if(quest.contains("Введите ключ")){
                answer = getKey(quest);
            } else {
                System.out.println(quest);
                answer = scanner.nextLine();
            }
            args[i] = answer;
        }
        return args;
    }

    private static int getAction(Scanner scanner){
        int action;
        do{
            System.out.println(MESSAGE_SELECT_MODE);
            String input = scanner.nextLine();
            action = switch (input){
                //TODO Coding. Magic values or methods. Bad reading and understanding
                case "1" -> 0;
                case "2" -> 1;
                case "3" -> 2;
                case "4" -> 3;
                default -> {
                    System.out.println(INCORRECT_SELECTION);
                    yield -1;
                }
            };
        } while (action < 0);
        return action;
    }

    private String getFilePath(String quest) {
        String filePath = null;
        boolean isExit = false;
        while (!isExit) {
            System.out.println(quest);
            String path = scanner.nextLine();
            Path checkFilePath = Path.of(path);
            if (!Files.isDirectory(checkFilePath) && Files.exists(checkFilePath) && isFileText(checkFilePath)){
                filePath = String.valueOf(checkFilePath);
                isExit = true;
            } else {
                System.out.printf("Не найден текстовый файл по указанному пути: \"%s\"%n", checkFilePath);
                isExit = responseAnswer();
                if(isExit){
                    System.out.println("Завершение работы программы...");
                    System.exit(0);
                }
            }
        }
        return filePath;
    }

    private boolean responseAnswer(){
        System.out.println("Попробуете еще раз? Ожидаемый ответ: Да/Нет");
        String answer;
        boolean isExit = false;
        do {
            answer = scanner.nextLine();
            if ("Нет".equalsIgnoreCase(answer)) {
                isExit = true;
            } else if ("Да".equalsIgnoreCase(answer)) {
                isExit = false;
            } else {
                System.out.println("Я не настолько умный (ಥ﹏ಥ). Ожидаемый ответ: Да/Нет");
            }
        } while (!"Нет".equalsIgnoreCase(answer) && !"Да".equalsIgnoreCase(answer));
        return isExit;
    }

    private boolean isFileText(Path path){
        String[] txtFiles = {".txt"};
        int dotIndex = String.valueOf(path).lastIndexOf(".");
        boolean isFileText = false;
        for(String txt : txtFiles){
            if (txt.equals(String.valueOf(path).substring(dotIndex))) {
                isFileText = true;
                break;
            }
        }
        if(!isFileText){
            System.out.println("Простите, я работаю только с форматом:");
            for(String txt : txtFiles){
                System.out.println(txt);
            }
        }
        return isFileText;
    }

    private String getKey(String quest) {
        System.out.println(quest);
        while (!scanner.hasNextInt()) {
            System.out.println("Простите, я не понял Ваш ответ (ಥ﹏ಥ). Ожидается число");
            scanner.next();
        }
        int key = scanner.nextInt();
        return String.valueOf(key);
    }
}
