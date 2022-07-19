package ru.javarush.cryptoanalyzer.graph.controllers;


import ru.javarush.cryptoanalyzer.graph.commands.Action;
import ru.javarush.cryptoanalyzer.graph.commands.BruteForce;
import ru.javarush.cryptoanalyzer.graph.commands.Decrypt;
import ru.javarush.cryptoanalyzer.graph.commands.Encrypt;

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
