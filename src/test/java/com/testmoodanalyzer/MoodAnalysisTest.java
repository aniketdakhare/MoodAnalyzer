package com.testmoodanalyzer;

import com.moodanalyzer.MoodAnalysis;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoodAnalysisTest
{
    MoodAnalysis moodAnalysis;
    @Before
    public void objectOf_MoodAnalysis_Class()
    {
        moodAnalysis = new MoodAnalysis();
    }

    @Test
    public void testSadMood()
    {
        String mood = moodAnalysis.analyzeMood("I am in Sad mood");
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void testHappyMood()
    {
        String mood = moodAnalysis.analyzeMood("I am in Happy mood");
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void testSadMood_ByPassing_ValueTo_Constructor()
    {
        MoodAnalysis sadMood = new MoodAnalysis("I am in Sad mood");
        String mood = sadMood.moodAnalyze();
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void testHappyMood_ByPassing_ValueTo_Constructor()
    {
        MoodAnalysis happyMood = new MoodAnalysis("I am in Happy mood");
        String mood = happyMood.moodAnalyze();
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void givenNullMassage_Should_Return_Happy()
    {
        String mood = moodAnalysis.analyzeMood(null);
        Assert.assertEquals("HAPPY",mood);
    }
}
