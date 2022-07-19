package ru.javarush.cryptoanalyzer.graph.commands;

import ru.javarush.cryptoanalyzer.graph.entity.Result;

import java.io.IOException;

public interface Action {
	Result execute(String[] parameters) throws IOException;
	
}
