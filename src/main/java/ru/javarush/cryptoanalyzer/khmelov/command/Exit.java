package ru.javarush.cryptoanalyzer.khmelov.command;

import ru.javarush.cryptoanalyzer.khmelov.constant.Const;
import ru.javarush.cryptoanalyzer.khmelov.entity.Result;
import ru.javarush.cryptoanalyzer.khmelov.entity.ResultCode;

public class Exit extends AbstractAction {

    @Override
    public Result execute(String[] parameters) {
        return new Result(ResultCode.OK, Const.APPLICATION_CLOSED);
    }
}
