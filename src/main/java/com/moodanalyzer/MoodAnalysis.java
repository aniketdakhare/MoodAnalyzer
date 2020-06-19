package com.moodanalyzer;

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
     * @param massage takes the mood
     * @return mood
     */
    public String analyzeMood(String massage)
    {
        this.massage = massage;
        return moodAnalyze();
    }

    public String moodAnalyze()
    {
        if (massage.contains("Sad"))
            return "SAD";
        else
            return "HAPPY";
    }

    public MoodAnalysis()
    {
    }
}
