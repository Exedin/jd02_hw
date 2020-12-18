package it.academy;

import java.util.List;

public class Average {
    public static double averageValue (List <Integer> list) {
        double avg=0;
        int sum=0;
        for (Integer integer : list) {
            sum+=integer;
        }
        avg= (double)sum/ list.size();
        return avg;
    }
}
