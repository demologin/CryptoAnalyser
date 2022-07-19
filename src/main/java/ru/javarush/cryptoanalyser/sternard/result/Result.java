package ru.javarush.cryptoanalyser.sternard.result;

import static ru.javarush.cryptoanalyser.sternard.util.ConsoleColors.*;

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
        if (getResultCode() == ResultCode.OK) {
            return GREEN_BOLD_BRIGHT + ResultCode.OK + "\n"
                    + getMessage() + RESET;
        } else if (getResultCode() == ResultCode.ERROR) {
            return RED_BOLD_BRIGHT + ResultCode.OK + "\n"
                    + getMessage() + RESET;
        } else if (getResultCode() == ResultCode.FAILED) {
            return YELLOW_BOLD + ResultCode.OK + "\n"
                    + getMessage() + RESET;
        }
        return ResultCode.OK + " " + getMessage();
    }
}