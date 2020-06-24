package com.bridgelabz.moodanalyzer.utility;

import com.bridgelabz.moodanalyzer.exception.MoodAnalysisException;
import com.bridgelabz.moodanalyzer.service.MoodAnalysis;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalysisFactory
{
    static String name = "com.bridgelabz.moodanalyzer.service.MoodAnalysis";

    public static MoodAnalysis createMoodAnalyser(String className,String massage)
    {
        try
        {
            Class<?> moodAnalysisClass;
            if (name.equals(className))
                moodAnalysisClass = Class.forName(className);
            else
                throw new MoodAnalysisException(MoodAnalysisException.ErrorType.ENTERED_WRONG_CLASS_NAME,
                        "No Such Class Error");
            Constructor<?> moodAnalysisConstructor = moodAnalysisClass.getConstructor(String.class);
            Object moodAnalysisObject = null;
            if (massage == null)
                moodAnalysisObject = moodAnalysisConstructor.newInstance(massage);
            else
                throw new MoodAnalysisException(MoodAnalysisException.ErrorType.ENTERED_WRONG_CONSTRUCTOR_PARAMETER,
                        "No Such Method Error");
            return (MoodAnalysis) moodAnalysisObject;
        }
        catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (MoodAnalysisException | IllegalAccessException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
