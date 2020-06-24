package com.bridgelabz.testmoodanalyzer;

import com.bridgelabz.moodanalyzer.service.MoodAnalysis;
import com.bridgelabz.moodanalyzer.exception.MoodAnalysisException;
import com.bridgelabz.moodanalyzer.utility.MoodAnalysisReflector;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MoodAnalysisTest
{
    MoodAnalysis moodAnalysis;
    @Before
    public void objectOf_MoodAnalysis_Class()
    {
        moodAnalysis = new MoodAnalysis();
        ExpectedException expectedException = ExpectedException.none();
        expectedException.expect(MoodAnalysisException.class);
    }

    @Test
    public void givenSadMood_ShouldReturnSad() throws MoodAnalysisException
    {
        String mood = moodAnalysis.analyzeMood("I am in Sad mood");
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void givenHappyMood_ShouldReturnHappy() throws MoodAnalysisException
    {
        String mood = moodAnalysis.analyzeMood("I am in Happy mood");
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void givenSadMood_ByPassingValueTo_Constructor_ShouldReturnSad() throws MoodAnalysisException
    {
        MoodAnalysis sadMood = new MoodAnalysis("I am in Sad mood");
        String mood = sadMood.analyzeMood();
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void givenHappyMood_ByPassingValueTo_Constructor_ShouldReturnHappy() throws MoodAnalysisException
    {
        MoodAnalysis happyMood = new MoodAnalysis("I am in Happy mood");
        String mood = happyMood.analyzeMood();
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void givenNullMassage_Should_Give_MoodAnalysisException()
    {
        try
        {
            moodAnalysis.analyzeMood(null);
        }
        catch (MoodAnalysisException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void givenEmptyMassage_Should_Give_MoodAnalysisException()
    {
        try
        {
            moodAnalysis.analyzeMood("");
        }
        catch (MoodAnalysisException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyzerClassName_ShouldReturnMoodAnalyzerObject_ForDefaultConstructor()
    {
        MoodAnalysis moodAnalyser = MoodAnalysisReflector.createMoodAnalyser("com.bridgelabz.moodanalyzer." +
                "service.MoodAnalysis",null);
        Assert.assertEquals(new MoodAnalysis(),moodAnalyser);
    }

    @Test
    public void givenClassNameWhenImproper_ShouldGive_MoodAnalysisException_ForDefaultConstructor()
    {
        MoodAnalysisReflector.createMoodAnalyser("com.bridgelabz.moodanalyzer.service.Mood",null);
    }

    @Test
    public void givenClassWithImproperConstructor_ShouldGive_MoodAnalysisException_ForDefaultConstructor()
    {
        MoodAnalysisReflector.createMoodAnalyser("com.bridgelabz.moodanalyzer.service.MoodAnalysis",
                "hi");
    }

    @Test
    public void givenMoodAnalyzerClassName_ShouldReturnMoodAnalyzerObject_ForParameterizedConstructor()
    {
        MoodAnalysis moodAnalyser = MoodAnalysisReflector.createMoodAnalyser("com.bridgelabz.moodanalyzer." +
                "service.MoodAnalysis","I am in Happy mood");
        Assert.assertEquals(new MoodAnalysis("I am in Happy mood"),moodAnalyser);
    }

    @Test
    public void givenClassNameWhenImproper_ShouldGive_MoodAnalysisException_ForParameterizedConstructor()
    {
        MoodAnalysisReflector.createMoodAnalyser("com.bridgelabz.moodanalyzer.service.Mood",
                "I am in Happy mood");
    }

    @Test
    public void givenClassWithImproperConstructor_ShouldGive_MoodAnalysisException_ForParameterizedConstructor()
    {
        MoodAnalysisReflector.createMoodAnalyser("com.bridgelabz.moodanalyzer.service.MoodAnalysis",
                34);
    }

    @Test
    public void givenHappyMood_UsingReflection_ShouldReturnHappy()
    {
        String mood = MoodAnalysisReflector.invokeAnalyzeMood("com.bridgelabz.moodanalyzer." +
                "service.MoodAnalysis","analyzeMood","I am in Happy mood");
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void givenHappyMoodToImproperMethod_UsingReflection_ShouldReturnHappy()
    {
        MoodAnalysisReflector.invokeAnalyzeMood("com.bridgelabz.moodanalyzer." +
                "service.MoodAnalysis","analyze","I am in Happy mood");
    }
}