package com.example.study;


/**
 * this is grade calculator
 */
public class GradeCalculator {
    public String calculateGrade(int mark) {
        if (mark > 100) {
            return "Please Enter Valid Mark";
        } else if (mark >= 80) {
            return "Congratulations !!! You have got A+";
        } else if (mark >= 70 && mark < 80) {
            return "Congratulations !!! You have got A";
        } else if (mark >= 60 && mark < 70) {
            return "Congratulations !!! You have got A-";
        } else if (mark >= 50 && mark < 60) {
            return "Congratulations !!! You have got B+";
        } else {
            return "Sorry Your grade is F";
        }
    }
}
