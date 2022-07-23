package ru.javarush.cryptoanalyzer.afonin.commands;

import ru.javarush.cryptoanalyzer.afonin.entity.Result;
import ru.javarush.cryptoanalyzer.afonin.entity.ResultCode;
import ru.javarush.cryptoanalyzer.afonin.util.ScramblerUtil;
import ru.javarush.cryptoanalyzer.afonin.util.MyFileUtils;


public class StatisticalDecrypt extends Action {

    @Override
    public String[] getRegexpValidateParameters() {
        return new String[]{
                MyFileUtils.getPathRegex(),
                MyFileUtils.getPathRegex()
        };
    }

    @Override
    public Result execute(String[] parameters) {
        //statistical-decrypt encoded.txt decodedAnalyse.txt dict.txt
        if (!checkParameters(parameters)) {
            return new Result(ResultCode.ERROR, "Некорректные параметры, повторите ввод.");
        }
        String encodedTxtFile = parameters[0];
        String outputDecodedTxtFile = parameters[1];
        String dictTxtFile = parameters[2];
        ScramblerUtil.staticticalDecrypt(encodedTxtFile, outputDecodedTxtFile, dictTxtFile);
        return new Result(ResultCode.OK, "Текст декодирован");
    }
}
