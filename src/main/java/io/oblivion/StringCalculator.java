package io.oblivion;

import java.util.ArrayList;
import java.util.List;

class StringCalculator {

    public static int add(String s) {
        String delimiter = ",|\n|\\t";
        String[] stringArrayInput = s.split(delimiter);
        List<Integer> negativeNumberList = new ArrayList<Integer>();
        int sum = 0;
        for (String i : stringArrayInput) {
            if (!i.isEmpty()) {
                if (Integer.parseInt(i)<1000 && Integer.parseInt(i)>0) {
                    sum += Integer.parseInt(i);
                } else if (Integer.parseInt(i)<0){
                    negativeNumberList.add(Integer.parseInt(i));
                }
            }
        }
        if (negativeNumberList.size() > 0) {
            throw new RuntimeException("Negatives not allowed: " + negativeNumberList.toString());
        } else
            return sum;


    }
}
