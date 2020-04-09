package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.company.CalculatorONP.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CalculatorONPTest {
    @Test
    public void test_prepare_returnListOfElements() throws Exception{
        //given
        inputLine = "5 1 2 + 4 * + 3 −";
        List<String> expectedList = new ArrayList<>();
        expectedList.add("5");
        expectedList.add("1");
        expectedList.add("2");
        expectedList.add("+");
        expectedList.add("4");
        expectedList.add("*");
        expectedList.add("+");
        expectedList.add("3");
        expectedList.add("−");

        //when
        assertEquals(expectedList,prepareItems());
    }

    @Test
    public void test_isSymbol_subtract_returnTrue(){
        assertTrue(isSymbol("-"));
    }

    @Test
    public void test_isSymbol_sum_returnTrue(){
        assertTrue(isSymbol("+"));
    }

    @Test
    public void test_isSymbol_multiply_returnTrue(){
        assertTrue(isSymbol("*"));
    }

    @Test
    public void test_isSymbol_division_returnTrue(){
        assertTrue(isSymbol("/"));
    }

    @Test
    public void test_isSymbol_exp_returnTrue(){
        assertTrue(isSymbol("^"));
    }

    @Test
    public void test_count_2_5_sum_return7(){
        String expectedResult = "7.0";
        assertEquals(expectedResult,count("+","2","5"));
    }

    @Test
    public void test_count_2_5_subtract(){
        String expectedResult = "-7.0";
        assertEquals(expectedResult,count("-","5","-2"));
    }

    @Test
    public void test_count_3_7_multiply(){
        String expectedResult = "21.0";
        assertEquals(expectedResult,count("*","3","7"));
    }

    @Test
    public void test_count_10_5_division(){
        String expectedResult = "2.0";
        assertEquals(expectedResult,count("/","5","10"));
    }

    @Test
    public void test_count_2_5_exp(){
        String expectedResult = "32.0";
        assertEquals(expectedResult,count("^","5","2"));
    }

    @Test
    public void test_calculator_return_40() throws Exception{
        //given
        inputLine = "12 2 3 4 * 10 5 / + * +";
        Double result = calculate(prepareItems());
        Double expectedOutput = 40.0 ;
        //when
        assertEquals(expectedOutput,result);
    }

    @Test
    public void test_calculator_return_14() throws Exception{
        //given
        inputLine = "5 1 2 + 4 * + 3 −";
        Double result = calculate(prepareItems());
        Double expectedOutput = 14.0 ;
        //when
        assertEquals(expectedOutput,result);
    }

    @Test(expected = Exception.class)
    public void test_prepare_nullInput_throwException() throws Exception{
        //given
        inputLine = null;
        //when
        prepareItems();
    }

    @Test(expected = Exception.class)
    public void test_prepare_equationIncludeChar_throwException() throws Exception{
        //given
        inputLine = "2 2+s";
        //when
        prepareItems();
    }

    @Test(expected = Exception.class)
    public void test_calculate_notONPinput_ThrowException() throws Exception{
        //given
        inputLine = "2 + 1";
        //when
        calculate(prepareItems());
    }


}
