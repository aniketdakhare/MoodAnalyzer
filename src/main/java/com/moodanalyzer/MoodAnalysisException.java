package com.moodanalyzer;

public class MoodAnalysisException extends Exception
{
    enum ErrorType
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
