package com.testmoodanalyzer;

import com.moodanalyzer.MoodAnalysis;
import com.moodanalyzer.MoodAnalysisException;
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
}