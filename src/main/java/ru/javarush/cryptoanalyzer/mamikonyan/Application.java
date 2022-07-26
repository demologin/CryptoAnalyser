package ru.javarush.cryptoanalyzer.mamikonyan;

import java.util.Arrays;
import ru.javarush.cryptoanalyzer.mamikonyan.controllers.MainController;
import ru.javarush.cryptoanalyzer.mamikonyan.exceptions.AppException;

public class Application {

  private final MainController mainController;

  public Application() {
    mainController = new MainController();
  }

  public void run(String[] args) {
    if (args.length > 0) {
      String action = args[0];
      String[] parameters = Arrays.copyOfRange(args, 1, args.length);
      mainController.doAction(action, parameters);
    } else {
      //TODO ---  and? need catch the AppException
      throw new AppException("Неправильное количество переданных параметров");
    }
  }
}
