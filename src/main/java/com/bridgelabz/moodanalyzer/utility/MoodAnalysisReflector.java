package com.bridgelabz.moodanalyzer.utility;

import com.bridgelabz.moodanalyzer.exception.MoodAnalysisException;
import com.bridgelabz.moodanalyzer.service.MoodAnalysis;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalysisReflector <T>
{
    static String name = "com.bridgelabz.moodanalyzer.service.MoodAnalysis";
    static String method= "analyzeMood";
    static String fieldMassage = "massage";

    public static <T> MoodAnalysis createMoodAnalyser(String className,T massage)
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
            Object moodAnalysisObject;
            if (massage instanceof String || massage == null)
                moodAnalysisObject = moodAnalysisConstructor.newInstance(massage);
            else
                throw new MoodAnalysisException(MoodAnalysisException.ErrorType.ENTERED_WRONG_CONSTRUCTOR_PARAMETER,
                        "No Such Method Error");
            return (MoodAnalysis) moodAnalysisObject;
        }
        catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException  e)
        {
            e.printStackTrace();
        }
        catch (MoodAnalysisException | IllegalAccessException | InstantiationException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> String invokeAnalyzeMood(String className,String methodName, T massage)
    {
        String mood = null;
        try
        {
            Method methods;
            if (method.equals(methodName))
                methods = MoodAnalysis.class.getMethod(methodName);
            else
                throw new MoodAnalysisException(MoodAnalysisException.ErrorType.ENTERED_WRONG_METHOD_NAME,
                        "No Such Method Error");
            MoodAnalysis moodAnalysis = createMoodAnalyser(className, massage);
            mood = (String) methods.invoke(moodAnalysis);
        }
        catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e)
        {
            e.printStackTrace();
        }
        catch (MoodAnalysisException e)
        {
            e.printStackTrace();
        }
        return mood;
    }

    public static<T> String dynamicMood(String className,String methodName,String fieldVariable, T massage)
    {
        String mood = null;
        try
        {
            if (fieldMassage.equals(fieldVariable))
            {
                Field fieldMood = MoodAnalysis.class.getField(fieldVariable);
                if (((String) massage).contains("Sad"))
                    fieldMood.set(massage,"Sad");
                else
                    fieldMood.set(massage,"Happy");
            }
            else
            {
                throw new MoodAnalysisException(MoodAnalysisException.ErrorType.ENTERED_WRONG_FIELD,
                        "No Such Field Error");
            }
        mood = invokeAnalyzeMood(className, methodName, massage);
        }
        catch (NoSuchFieldException | IllegalAccessException | MoodAnalysisException e)
        {
            e.printStackTrace();
        }
        return mood;
    }
}
