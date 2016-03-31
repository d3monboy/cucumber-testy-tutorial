package org.fasttrackit.util;

/**
 * Created by mihai on 3/3/2016.
 */
public class test {
    public static void main(String[] args) {
        Calculator calc = new Calculator(3);

        int sum = calc.add(7879, 987);
        System.out.println(sum);

        sum = calc.add(5, 9);
        System.out.println(sum);

    }



}
