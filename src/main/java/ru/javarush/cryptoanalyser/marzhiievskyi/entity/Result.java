package ru.javarush.cryptoanalyser.marzhiievskyi.entity;

import ru.javarush.cryptoanalyser.marzhiievskyi.constants.Strings;

public class Result {
    private final ResultCode resultCode;
    private final String message;

    public Result(ResultCode resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return Strings.ANSI_YELLOW + "Результат работы программы: " +
                "\nкод результата = "+Strings.ANSI_RESET  + resultCode +
                Strings.ANSI_YELLOW + "\nсообщение = " +Strings.ANSI_RESET + message;
    }
}
