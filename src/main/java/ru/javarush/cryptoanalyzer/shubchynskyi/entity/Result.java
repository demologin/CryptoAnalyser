package ru.javarush.cryptoanalyzer.shubchynskyi.entity;

public record Result(ResultCode resultCode, String message) {

    @Override
    public String toString() {
        return "Result{" +
                "resultCode=" + resultCode +
                ", message='" + message + '\'' +
                '}';
    }
}
