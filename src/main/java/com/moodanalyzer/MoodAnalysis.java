package com.moodanalyzer;

public class MoodAnalysis
{
    String massage;

    /**
     * Parameterized Constructor to initialize massage
     * @param massage takes massage
     */
    public MoodAnalysis(String massage)
    {
        this.massage = massage;
    }

    /**
     * METHOD TO ANALYSE THE MOOD OF A PERSON
     * @return mood
     * @throws MoodAnalysisException handles custom exception
     */
    public String moodAnalyze() throws MoodAnalysisException
    {
        return analyzeMood(massage);
    }

    /**
     * PARAMETERIZED METHOD TO ANALYSE THE MOOD OF A PERSON
     * @param massage takes the mood
     * @return mood
     */
    public String analyzeMood(String massage) throws MoodAnalysisException
    {
        try
        {
            if (massage.contains("Sad"))
                return "SAD";
            else
                return "HAPPY";
        }
        catch (NullPointerException ne)
        {
            throw new MoodAnalysisException(MoodAnalysisException.ErrorType.ENTERED_NULL_VALUE, "Please enter the valid massage");
        }
    }

    public MoodAnalysis()
    {
    }
}
