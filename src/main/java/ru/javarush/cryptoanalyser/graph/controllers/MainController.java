package ru.javarush.cryptoanalyser.graph.controllers;

import ru.javarush.cryptoanalyser.graph.commands.Action;
import ru.javarush.cryptoanalyser.graph.entity.Result;
import ru.javarush.cryptoanalyser.graph.entity.ResultCode;
import ru.javarush.cryptoanalyser.graph.exception.AppException;

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
