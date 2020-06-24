package com.bridgelabz.moodanalyzer.service;

import com.bridgelabz.moodanalyzer.exception.MoodAnalysisException;

import java.util.Objects;

public class MoodAnalysis
{
    String massage;

    /**
     * Parameterized Constructor to initialize massage
     * @param massage takes massage
     */
    public MoodAnalysis(String massage)
    {
        this.massage = massage;
    }

    /**
     * METHOD TO ANALYSE THE MOOD OF A PERSON
     * @return mood
     * @throws MoodAnalysisException handles custom exception
     */
    public String moodAnalyze() throws MoodAnalysisException
    {
        return analyzeMood(massage);
    }

    /**
     * PARAMETERIZED METHOD TO ANALYSE THE MOOD OF A PERSON
     * @param massage takes the mood
     * @return mood
     */
    public String analyzeMood(String massage) throws MoodAnalysisException
    {
        try
        {
            if ( massage.length() == 0 )
                throw new MoodAnalysisException(MoodAnalysisException.ErrorType.ENTERED_EMPTY_VALUE, "It is empty," +
                        " please enter some massage");
            else if (massage.contains("Sad"))
                return "SAD";
            else
                return "HAPPY";
        }
        catch (NullPointerException ne)
        {
            throw new MoodAnalysisException(MoodAnalysisException.ErrorType.ENTERED_NULL_VALUE, "Please enter the" +
                    " valid massage");
        }
    }

    public MoodAnalysis()
    {
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoodAnalysis that = (MoodAnalysis) o;
        return Objects.equals(massage, that.massage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(massage);
    }
}