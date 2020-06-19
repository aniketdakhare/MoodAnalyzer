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
        String mood = moodAnalysis.analyseMood("This is Sad mood");
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void testHappyMood()
    {
        String mood = moodAnalysis.analyseMood("This is Happy mood");
        Assert.assertEquals("HAPPY",mood);
    }
}
