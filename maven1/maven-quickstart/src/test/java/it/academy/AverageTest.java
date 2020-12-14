package it.academy;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class AverageTest {
    @Test
    public void averageValueTest (){
        List<Integer> integerList= Arrays.asList(5,6,7,8);
        double expected=6.5;
        double actual=Average.averageValue(integerList);
        assertEquals(expected,actual,0.00001);
    }

}