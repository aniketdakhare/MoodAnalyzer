package com.testmoodanalyzer;

import com.moodanalyzer.MoodAnalysis;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoodAnalysisTest
{
    @Test
    public void testAnalyzeMood()
    {
        MoodAnalysis moodAnalysis = new MoodAnalysis();
        String mood = moodAnalysis.analyseMood("This is Sad mood");
        Assert.assertEquals("SAD",mood);
    }
}
