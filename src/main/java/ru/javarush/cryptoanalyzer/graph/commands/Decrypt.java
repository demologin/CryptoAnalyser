package ru.javarush.cryptoanalyzer.graph.commands;

import ru.javarush.cryptoanalyzer.graph.entity.Result;
import ru.javarush.cryptoanalyzer.graph.entity.ResultCode;
import ru.javarush.cryptoanalyzer.graph.exception.AppException;
import ru.javarush.cryptoanalyzer.graph.util.PathFinder;
import ru.javarush.cryptoanalyzer.graph.constant.Constants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Decrypt implements Action {
	
	@Override
	public Result execute(String[] parameters) throws IOException {
		
		String encryptedFile = parameters[0];
		String decryptedFile = parameters[1];
		int key = Integer.parseInt(parameters[2]);
		String decrypted = "";
		Path path = Path.of(PathFinder.getRoot() + encryptedFile);
		
		try {
			String strings = String.valueOf(Files.readAllLines(path));
			for (int i = 0; i < strings.length(); i++) {
				int index = Constants.ALPHABET.indexOf(strings.charAt(Integer.parseInt(String.valueOf(i))));
				int newIndex = (Constants.ALPHABET.length() + index - key) % Constants.ALPHABET.length();
				if (newIndex < 0) {
					newIndex = Constants.ALPHABET.length() + newIndex;
				}
				char replaceChar = Constants.ALPHABET.charAt(newIndex);
				//TODO Code style. Many warnings. Skip or fix it.
				decrypted += replaceChar;
			}
			//TODO ---	name???
			Path path2 = Path.of(PathFinder.getRoot() + decryptedFile);
			Files.write(Paths.get(String.valueOf(path2)), decrypted.getBytes());
			
		} catch (IOException e) {
			throw new AppException("Not found", e);
		}
		//TODO Coding. Magic values or methods. Bad reading and understanding
		return new Result(ResultCode.OK, "all bytes read" + path);
	}
}