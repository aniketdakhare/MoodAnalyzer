package com.bridgelabz.moodanalyzer.exception;

public class MoodAnalysisException extends Exception
{
    public enum ErrorType
    {
        ENTERED_NULL_VALUE, ENTERED_EMPTY_VALUE
    }

    ErrorType type;

    public MoodAnalysisException(ErrorType type, String massage)
    {
        super(massage);
        this.type = type;
    }
}