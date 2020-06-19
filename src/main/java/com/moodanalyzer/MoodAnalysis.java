package com.moodanalyzer;

public class MoodAnalysis
{
    /**
     * METHOD TO ANALYSE THE MOOD OF A PERSON
     * @param massage takes the mood
     * @return mood
     */
    public String analyseMood(String massage)
    {
        if (massage.contains("Sad"))
            return "SAD";
        else
            return "HAPPY";
    }
}
