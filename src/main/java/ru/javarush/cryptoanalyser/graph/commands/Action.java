package ru.javarush.cryptoanalyser.graph.commands;

import ru.javarush.cryptoanalyser.graph.entity.Result;

import java.io.IOException;

public interface Action {
	Result execute(String[] parameters) throws IOException;
	
}
