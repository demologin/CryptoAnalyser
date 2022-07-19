package ru.javarush.cryptoanalyser.graph;

import ru.javarush.cryptoanalyser.graph.app.Application;
import ru.javarush.cryptoanalyser.graph.constant.Constants;
import ru.javarush.cryptoanalyser.graph.controllers.MainController;
import ru.javarush.cryptoanalyser.graph.entity.Result;

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