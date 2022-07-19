package ru.javarush.cryptoanalyser.graph.controllers;


import ru.javarush.cryptoanalyser.graph.commands.Action;
import ru.javarush.cryptoanalyser.graph.commands.BruteForce;
import ru.javarush.cryptoanalyser.graph.commands.Decrypt;
import ru.javarush.cryptoanalyser.graph.commands.Encrypt;

public enum Actions {
	
	ENCRYPT(new Encrypt()),
	DECRYPT(new Decrypt()),
	BRUTEFORCE(new BruteForce());
	
	private final Action action;
	
	Actions(Action action) {
		this.action = action;
	}
	
	public static Action find(String command) {
		return Actions.valueOf(command.toUpperCase()).action;
	}
}
