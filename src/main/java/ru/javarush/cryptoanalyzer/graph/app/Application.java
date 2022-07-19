package ru.javarush.cryptoanalyzer.graph.app;

import ru.javarush.cryptoanalyzer.graph.controllers.MainController;
import ru.javarush.cryptoanalyzer.graph.entity.Result;

import java.util.Arrays;

public class Application {
	
	private final MainController mainController;
	
	public Application(MainController mainController) {
		this.mainController = mainController;
	}
	
	public Result run(String[] args) {
		// encode text.txt encoded.txt 45
			String command = args[0];
			String[] parameters = Arrays.copyOfRange(args, 1, args.length); // encode text.txt encoded.txt 45
			return mainController.execute(command, parameters);
	}
}
