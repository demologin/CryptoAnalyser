package ru.javarush.cryptoanalyzer.graph;

import ru.javarush.cryptoanalyzer.graph.app.Application;
import ru.javarush.cryptoanalyzer.graph.constant.Constants;
import ru.javarush.cryptoanalyzer.graph.controllers.MainController;
import ru.javarush.cryptoanalyzer.graph.entity.Result;

public class MainApp {
	
	public static void main(String[] args) throws Exception {
		
		MainController mainController = new MainController();
		// TODO encrypt text.txt encoded.txt 45
		Application application = new Application(mainController);
		Result result = application.run(args);
		System.out.println(result);
		String txtFolder = Constants.TXT_FOLDER;
		System.out.println(txtFolder);
	}
	
}