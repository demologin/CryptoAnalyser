package ru.javarush.cryptoanalyzer.bogdanov.entity;

public class Result {
    private final  ResultCode resultCode;
    private final String massage;

    public ResultCode getResultCode() {
        return resultCode;
    }

    @Override
    public String toString() {
        return "Result{" + "resultCode=" + resultCode + ", massage='" + massage + '\'' + '}';
    }

    public String getMassage() {
        return massage;
    }

    public Result(ResultCode resultCode, String massage) {
        this.resultCode = resultCode;
        this.massage = massage;
    }
}
