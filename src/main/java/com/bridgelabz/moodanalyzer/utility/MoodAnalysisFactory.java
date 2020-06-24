package com.bridgelabz.moodanalyzer.utility;

import com.bridgelabz.moodanalyzer.exception.MoodAnalysisException;
import com.bridgelabz.moodanalyzer.service.MoodAnalysis;

public class MoodAnalysisFactory
{
    static String name = "com.bridgelabz.moodanalyzer.service.MoodAnalysis";

    public static MoodAnalysis createMoodAnalyser(String className)
    {
        try
        {
            Class<?> moodAnalysisClass;
            if (name.equals(className))
            {
                moodAnalysisClass = Class.forName(className);
            }
            else
            {
                throw new MoodAnalysisException(MoodAnalysisException.ErrorType.ENTERED_WRONG_CLASS_NAME,
                        "No Such Class Error");
            }
            Object moodAnalysisObject = moodAnalysisClass.newInstance();
            return (MoodAnalysis) moodAnalysisObject;
        }
        catch (ClassNotFoundException | IllegalAccessException | InstantiationException e)
        {
            e.printStackTrace();
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
        return null;
    }
}
