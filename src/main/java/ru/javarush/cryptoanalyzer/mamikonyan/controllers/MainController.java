package ru.javarush.cryptoanalyzer.mamikonyan.controllers;

import ru.javarush.cryptoanalyzer.mamikonyan.commands.BrutForce;
import ru.javarush.cryptoanalyzer.mamikonyan.commands.Decoder;
import ru.javarush.cryptoanalyzer.mamikonyan.commands.Encoder;
import ru.javarush.cryptoanalyzer.mamikonyan.exceptions.ActionException;

public class MainController {

  public void doAction(String action, String[] parameters) {
    switch (action) {
      case "1" -> {
        Encoder encoder = new Encoder();
        encoder.execute(parameters);
      }
      case "2" -> {
        Decoder decoder = new Decoder();
        decoder.execute(parameters);
      }
      case "3" -> {
        BrutForce brutForce = new BrutForce();
        brutForce.execute(parameters);
      }
      //TODO Coding. Magic values or methods. Bad reading and understanding
      default -> throw new ActionException("Выбрано неправильное действие");
      //TODO ---  and? need catch the AppException
    }
  }
}
