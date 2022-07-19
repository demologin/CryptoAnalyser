package ru.javarush.cryptoanalyzer.kislyakova.util;
import ru.javarush.cryptoanalyzer.kislyakova.exception.AppException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CreateResultFile {

    public static void createFileWithResult(Path filePath, String action, StringBuilder newText){
        String newFileNameWithFullPath = getNewFileName(filePath, action);
        Path newFilePath = Path.of(newFileNameWithFullPath);
        try {
            boolean fileIsExist;
            if (Files.notExists(newFilePath)) {
                Files.createFile(newFilePath);
                fileIsExist = false;
            } else {
                Files.delete(newFilePath);
                Files.createFile(newFilePath);
                fileIsExist = true;
            }
            String textForNewFile = String.valueOf(newText);
            Files.writeString(newFilePath, textForNewFile);
            if(!fileIsExist){
                System.out.printf("Все готово! Результат работы находится в файле: %s%n", newFileNameWithFullPath);
            } else {
                System.out.printf("Все готово! Результат работы находится в файле: %s%n" +
                                "Во время своей работы я подставил в имя название выбранной опции, как оказалось, " +
                                "у вас уже был такой файл.%nЯ удалил старый и заменил его новым (уж извините, если не надо было).%n",
                        newFileNameWithFullPath);
            }
        } catch (IOException e){
            e.printStackTrace();
            throw new AppException("Произошла ошибка при работе с файлом", e);
        }
    }

    private static String getNewFileName(Path filePath, String action) {
        String newFileName = String.valueOf(filePath);
        int dotIndex = newFileName.lastIndexOf(".");
        newFileName = newFileName.substring(0, dotIndex) + action + newFileName.substring(dotIndex);
        return newFileName;
    }
}
