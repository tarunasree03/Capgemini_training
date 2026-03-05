package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalcTesting {
    @ParameterizedTest
    @CsvSource(
            {
                    "'10', '20', '30', 'SUCCESS' ",
                    "'abc', '7', '12', 'ERROR' ",
                    "'-10.5', '10.5', '0', 'SUCCESS' "
            }
    )

    void checkSuccess(String a, String b, String expected, String status){
        Calc calc = new Calc();
    }

//    void addTest(double a, double b, double expected){
//        Calc calc = new Calc();
//        double result = calc.add(a, b);
//        assertEquals(expected, result);
//    }

    //    @Test
//    void addTest(double a, double b, double expected){
//        Calc calc = new Calc();
//        double result = calc.add(a, b);
//        assertEquals(expected, result);
//    }

//    @Test
//    void addInvalidStringTest(){
//        Calc calc = new Calc();
//        assertThrows(IllegalArgumentException.class,
//                () -> calc.add("11", "25"));
//    }
}
