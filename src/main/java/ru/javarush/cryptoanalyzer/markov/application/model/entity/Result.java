package ru.javarush.cryptoanalyzer.markov.application.model.entity;

import java.util.List;

public class Result {



    private final ResultCode resultCode;

    private final String message;

    private List<Character> text;

    public Result(ResultCode resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    public Result(ResultCode resultCode, String message, List<Character> result) {
        this.resultCode = resultCode;
        this.message = message;
        this.text = result;
    }

    public List<Character> getText() {
        return text;
    }

    public ResultCode getResultCode() {
        throw new UnsupportedOperationException();
    }

    public String getMessage() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultCode=" + resultCode +
                ", message='" + message + '\'' +
                '}';
    }
}
