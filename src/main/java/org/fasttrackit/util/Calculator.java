package org.fasttrackit.util;

/**
 * Created by mihai on 3/3/2016.
 */
public class Calculator {
    private static int maxnumber;

    public Calculator(int maxlenght) {
        switch (maxnumber = (int) Math.pow(10, maxlenght)) {
        }

    }

    public static int add(int a, int b) {
        int s = a + b;


        if(s >= maxnumber) {
                System.out.println("sum was" + s);
                s = maxnumber;
        }
        return a + b;
    }
}
