package ru.javarush.cryptoanalyzer.graph.controllers;

import ru.javarush.cryptoanalyzer.graph.commands.Action;
import ru.javarush.cryptoanalyzer.graph.entity.Result;
import ru.javarush.cryptoanalyzer.graph.entity.ResultCode;
import ru.javarush.cryptoanalyzer.graph.exception.AppException;

import java.io.IOException;

public class MainController {
	
	public Result execute(String command, String[] parameters) {
		try {
			Action action = Actions.find(command);
			return action.execute(parameters);
		} catch (AppException e) {
			//TODO log file for exception
			return new Result(ResultCode.ERROR, e.getMessage());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	}
