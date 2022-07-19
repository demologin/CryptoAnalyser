package ru.javarush.cryptoanalyzer.kislyakova.commands;
import org.apache.commons.math3.stat.inference.ChiSquareTest;
import ru.javarush.cryptoanalyzer.kislyakova.entity.Result;
import ru.javarush.cryptoanalyzer.kislyakova.entity.ResultCode;
import ru.javarush.cryptoanalyzer.kislyakova.exception.AppException;
import ru.javarush.cryptoanalyzer.kislyakova.util.CreateResultFile;
import static ru.javarush.cryptoanalyzer.kislyakova.constants.CipherConstants.*;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Bruteforce implements Action {
    @Override
    public Result execute(String[] parameters) {
        Path filePath = Path.of(parameters[0]);
        String text;
        try {
            text = Files.readString(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            throw new AppException("Произошла ошибка при работе с файлом", e);
        }
        StringBuilder resultText = bruteforce(text);
        CreateResultFile.createFileWithResult(filePath, "_bruteforce", resultText);
        return new Result(ResultCode.OK, "Bruteforce");
    }
    
    

    private StringBuilder bruteforce(String text){
        int keyFound = bruteforceKey(text);
        Decipher decipher = new Decipher();
        String textAfterBruteforce = String.valueOf(decipher.decipher(text, keyFound));
        int i = checkPunctuation(textAfterBruteforce);
        if (PUNCTUATION_CHAR_ARRAY[i] != ' ') {
            keyFound = keyFound - ALPHABET_RUS_LENGTH;
        }
        return decipher.decipher(text, keyFound);
    }

    //ищем код
    private int bruteforceKey(String text) {
        return probableOffset(chiSquares(text));
    }

    //TODO Code style. User russian comments? Bad English is much better than the best Russian comments.    
    //Создание массива, который будет содержать вычисленные Хи-квадраты для каждого смещения от 0 до 32
    //используем каждое смещение, а затем считаем буквы в этом сообщении
    //метод ChiSquareTest (из maven) для вычисления Хи-квадрата между ожидаемым и наблюдаемым распределением букв
    private double[] chiSquares(String text) {
        double[] expectedLettersFrequencies = expectedLettersFrequencies(text.length());
        double[] chiSquares = new double[ALPHABET_RUS_LENGTH];
        for (int offset = 0; offset < chiSquares.length; offset++) {
            Decipher decipher = new Decipher();
            String decipheredMessage = String.valueOf(decipher.decipher(text, offset));
            long[] lettersFrequencies = observedLettersFrequencies(decipheredMessage);
            double chiSquare = new ChiSquareTest().chiSquare(expectedLettersFrequencies, lettersFrequencies);
            chiSquares[offset] = chiSquare;
        }

        return chiSquares;
    }

    //Метод определяет количество букв от "а" до "я" (включая ё) в переданном сообщении
    private long[] observedLettersFrequencies(String text) {
        IntStream intStream = CharBuffer.wrap(RUS_SMALL_LETTER.toCharArray()).chars();
        return intStream
                .mapToLong(letter -> countLetter((char) letter, text))
                .toArray();
    }

    //вспомогательный метод для observedLettersFrequencies - определяем частоту буквы в тексте
    private long countLetter(char letter, String text) {
        return text.chars()
                .filter(character -> character == letter)
                .count();
    }

    //Метод для вычисления ожидаемых частот букв в сообщении
    //на основе умножения вероятности (RUS_LETTERS_PROBABILITIES) на длину сообщения
    private double[] expectedLettersFrequencies(int messageLength) {
        return Arrays.stream(RUS_LETTERS_PROBABILITIES)
                .map(probability -> probability * messageLength)
                .toArray();
    }

    //Метод для получения смещения:
    //после вычисления всех Хи-квадратов можем вернуть смещение, соответствующее наименьшему Хи-квадрату
    private int probableOffset(double[] chiSquares) {
        int probableOffset = 0;
        for (int offset = 0; offset < chiSquares.length; offset++) {
            if (chiSquares[offset] < chiSquares[probableOffset]) {
                probableOffset = offset;
            }
        }
        return probableOffset;
    }

    //метод для проверки ключа на основе совпадения с пунктуацией (когда ключ со сдвигом в минус указан)
    private int checkPunctuation(String text){
        String assertText = text.length() < 20 ? text : text.substring(0, 19);
        int[] punctuationFrequencies = new int[PUNCTUATION_LENGTH];
        for (char character : assertText.toCharArray()){
            //если символ есть в алфавите пунктуации
            int indexFindChar = new String(PUNCTUATION_CHAR_ARRAY).indexOf(character);
            if(indexFindChar != -1){
                punctuationFrequencies[indexFindChar] ++;
            }
        }
        return getIndexOfMaxFrequency(punctuationFrequencies);
    }

    //метод для поиска наибольшего элемента массива, чтобы потом определить, какой знак встречается чаще
    private static int getIndexOfMaxFrequency(int[] inputArray){
        int maxValue = inputArray[0];
        int indexOfMaxValue = 0;
        for(int i = 0; i < inputArray.length; i++){
            if(inputArray[i] > maxValue){
                maxValue = inputArray[i];
                indexOfMaxValue = i;
            }
        }
        return indexOfMaxValue;
    }
}
