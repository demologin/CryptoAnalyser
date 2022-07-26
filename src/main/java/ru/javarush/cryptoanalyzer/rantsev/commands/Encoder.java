package ru.javarush.cryptoanalyzer.rantsev.commands;

import ru.javarush.cryptoanalyzer.rantsev.entity.Result;
import ru.javarush.cryptoanalyzer.rantsev.entity.ResultCode;

public class Encoder implements Action{
    @Override
    public void execute(String[] parameters) {
        int key = Integer.parseInt(parameters[2]);
        if (key > 44) {
            key = key%44;
        }
        CypherCaesar cypherCaesar = new CypherCaesar(parameters[0], parameters[1], key);
        cypherCaesar.getCypher();
        new Result(ResultCode.OK, "File is ready");
    }
}
