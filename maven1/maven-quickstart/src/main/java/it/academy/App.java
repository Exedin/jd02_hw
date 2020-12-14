package it.academy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        long x=10;
        long y=square(x);
        System.out.println(y);
        List <Integer> integerList= Arrays.asList(1,2,3,4,5);
        double avg=Average.averageValue(integerList);
        System.out.println(avg);


    }
    public static long square (long x){
        return x*x;
    }

}
