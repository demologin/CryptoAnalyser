package ru.javarush.cryptoanalyzer.afonin.commands;

import ru.javarush.cryptoanalyzer.afonin.entity.Result;
import ru.javarush.cryptoanalyzer.afonin.entity.ResultCode;
import ru.javarush.cryptoanalyzer.afonin.util.ScramblerUtil;
import ru.javarush.cryptoanalyzer.afonin.util.MyFileUtils;


public class Encoder extends Action{
    //private final String[] regexpParameters = ;

    @Override
    public String[] getRegexpValidateParameters() {
        return new String[]{
                MyFileUtils.getPathRegex(),
                MyFileUtils.getPathRegex(),
                "\\d+"};
    }

    @Override
    public Result execute(String[] parameters) {
        //encode text.txt encoded.txt 9
        if (!checkParameters(parameters)) {
            return new Result(ResultCode.ERROR, "Некорректные параметры, повторите ввод.");
        }

        String inputTxtFile = parameters[0];
        String outputEncryptedTxtFile = parameters[1];
        int keyShift = Integer.parseInt(parameters[2]);
        ScramblerUtil.cesarCipher(inputTxtFile, outputEncryptedTxtFile, keyShift);
        return new Result(ResultCode.OK, "Текст закодирован");
    }

}
