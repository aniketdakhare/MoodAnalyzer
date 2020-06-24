package com.bridgelabz.moodanalyzer.utility;

import com.bridgelabz.moodanalyzer.service.MoodAnalysis;

public class MoodAnalysisFactory
{
    public static MoodAnalysis createMoodAnalyser()
    {
        try
        {
            Class<?> moodAnalysisClass = Class.forName("com.bridgelabz.moodanalyzer.service.MoodAnalysis");
            Object moodAnalysisObject = moodAnalysisClass.newInstance();
            return (MoodAnalysis) moodAnalysisObject;
        }
        catch (ClassNotFoundException | IllegalAccessException | InstantiationException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
