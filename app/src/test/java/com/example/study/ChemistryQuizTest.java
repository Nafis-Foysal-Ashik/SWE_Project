package com.example.study;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChemistryQuizTest {

    @Test
    public void testCheckAnswer_CorrectAnswer() {
        ChemistryQuiz quiz = new ChemistryQuiz();
        boolean result = quiz.checkAnswer("Na");
        assertTrue(result);
    }

    @Test
    public void testCheckAnswer_IncorrectAnswer() {
        ChemistryQuiz quiz = new ChemistryQuiz();
        boolean result = quiz.checkAnswer("NaCl");
        assertFalse(result);
    }

    @Test
    public void testIsLastQuestion_NotLastQuestion() {
        ChemistryQuiz quiz = new ChemistryQuiz();
        boolean result = quiz.isLastQuestion();
        assertFalse(result);
    }

    @Test
    public void testIsLastQuestion_LastQuestion() {
        ChemistryQuiz quiz = new ChemistryQuiz();
        // Move to the last question
        for (int i = 0; i < 4; i++) {
            quiz.moveToNextQuestion();
        }
        boolean result = quiz.isLastQuestion();
        assertTrue(result);
    }

//    @Test
//    public void testMoveToNextQuestion() {
//        ChemistryQuiz quiz = new ChemistryQuiz();
//        int initialIndex = quiz.getCurrentQuestionIndex();
//        quiz.moveToNextQuestion();
//        assertEquals(initialIndex + 1, quiz.getCurrentQuestionIndex());
//    }

    @Test
    public void testGetScore_InitiallyZero() {
        ChemistryQuiz quiz = new ChemistryQuiz();
        int score = quiz.getScore();
        assertEquals(0, score);
    }

    @Test
    public void testIncrementScore() {
        ChemistryQuiz quiz = new ChemistryQuiz();
        quiz.incrementScore();
        assertEquals(1, quiz.getScore());
    }
}
