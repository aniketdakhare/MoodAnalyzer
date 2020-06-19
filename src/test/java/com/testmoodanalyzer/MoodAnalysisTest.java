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
    public void testSadMood() throws MoodAnalysisException
    {
        String mood = moodAnalysis.analyzeMood("I am in Sad mood");
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void testHappyMood() throws MoodAnalysisException
    {
        String mood = moodAnalysis.analyzeMood("I am in Happy mood");
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void testSadMood_ByPassing_ValueTo_Constructor() throws MoodAnalysisException
    {
        MoodAnalysis sadMood = new MoodAnalysis("I am in Sad mood");
        String mood = sadMood.moodAnalyze();
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void testHappyMood_ByPassing_ValueTo_Constructor() throws MoodAnalysisException
    {
        MoodAnalysis happyMood = new MoodAnalysis("I am in Happy mood");
        String mood = happyMood.moodAnalyze();
        Assert.assertEquals("HAPPY",mood);
    }

    @Test
    public void givenNullMassage_Should_Return_Happy()
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
}
