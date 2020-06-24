package com.bridgelabz.testmoodanalyzer;

import com.bridgelabz.moodanalyzer.service.MoodAnalysis;
import com.bridgelabz.moodanalyzer.exception.MoodAnalysisException;
import com.bridgelabz.moodanalyzer.utility.MoodAnalysisFactory;
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
        String mood = sadMood.moodAnalyze();
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void givenHappyMood_ByPassingValueTo_Constructor_ShouldReturnHappy() throws MoodAnalysisException
    {
        MoodAnalysis happyMood = new MoodAnalysis("I am in Happy mood");
        String mood = happyMood.moodAnalyze();
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void givenNullMassage_Should_Give_MoodAnalysisException()
    {
        try
        {
            ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(MoodAnalysisException.class);
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
            ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(MoodAnalysisException.class);
            moodAnalysis.analyzeMood("");
        }
        catch (MoodAnalysisException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyzerClassName_ShouldReturnMoodAnalyzerObject()
    {
        MoodAnalysis moodAnalyser = MoodAnalysisFactory.createMoodAnalyser("com.bridgelabz.moodanalyzer." +
                "service.MoodAnalysis");
        Assert.assertEquals(new MoodAnalysis(),moodAnalyser);
    }

    @Test
    public void givenClassNameWhenImproper_ShouldGive_MoodAnalysisException()
    {
        ExpectedException expectedException = ExpectedException.none();
        expectedException.expect(MoodAnalysisException.class);
        MoodAnalysisFactory.createMoodAnalyser("com.bridgelabz.moodanalyzer.service.Mood");
    }
}