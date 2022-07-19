package ru.javarush.cryptoanalyser.molchanov.entity;

public class Result {
    private final ResultCode resultCode;
    private  final String message;

    public ResultCode getResultCode() {
        return resultCode;
    }

    public String getMessage() {
        return message;
    }

    public Result(ResultCode resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultCode=" + resultCode +
                ", message='" + message + '\'' +
                '}';
    }
}
