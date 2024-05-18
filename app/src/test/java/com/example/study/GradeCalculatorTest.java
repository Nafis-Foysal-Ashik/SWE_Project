package com.example.study;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GradeCalculatorTest {

    private final GradeCalculator calculator = new GradeCalculator();

    @Test
    public void testAPlusGrade() {
        assertEquals("Congratulations !!! You have got A+", calculator.calculateGrade(90));
    }

    @Test
    public void testAGrade() {
        assertEquals("Congratulations !!! You have got A", calculator.calculateGrade(75));
    }

    @Test
    public void testAMinusGrade() {
        assertEquals("Congratulations !!! You have got A-", calculator.calculateGrade(65));
    }

    @Test
    public void testBPlusGrade() {
        assertEquals("Congratulations !!! You have got B+", calculator.calculateGrade(55));
    }

    @Test
    public void testFGrade() {
        assertEquals("Sorry Your grade is F", calculator.calculateGrade(30));
    }

    @Test
    public void testInvalidMark() {
        assertEquals("Please Enter Valid Mark", calculator.calculateGrade(110));
    }
}
