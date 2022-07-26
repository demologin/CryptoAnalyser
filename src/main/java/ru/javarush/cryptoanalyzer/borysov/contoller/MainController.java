package ru.javarush.cryptoanalyzer.borysov.contoller;

import ru.javarush.cryptoanalyzer.borysov.service.BruteForce;
import ru.javarush.cryptoanalyzer.borysov.service.Decode;
import ru.javarush.cryptoanalyzer.borysov.service.Encode;
import ru.javarush.cryptoanalyzer.borysov.view.Console;

import java.nio.file.Path;

public class MainController {

    public MainController() {

    }

    public String extracted(String command) {
        return switch (command.toLowerCase()){
            //TODO ---  need pattern Command or Strategy
            case "encode"->{
                Path pathInputFile=Console.encodePathView();
                Path pathOutputFile=Console.loadFile();
                int key=Console.encodePath();

                yield Encode.encoder(pathInputFile,pathOutputFile,key);
            }

            case "decode"->{
                Path pathInputFile=Console.decodePathView();
                Path pathOutputFile=Console.loadFile();
                int key=Console.decodePath();
                yield Decode.decoder(pathInputFile,pathOutputFile,key);
            }
            case "bruteforce"->{
                Path pathInputFile=Console.decodePathView();
                Path pathOutputFile=Console.loadFile();
                yield BruteForce.brute(pathInputFile,pathOutputFile);
            }
            default -> "Такой команды не существует";
        };
    }
}
