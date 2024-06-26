package org.koreait;

import static org.koreait.Calc.run;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        run("10 - 20 + 30");
        String exp = " + 20";

       /* String firstExp = exp.substring(0, 9);
        String secondExp = exp.substring(9);

        System.out.println(firstExp);
        System.out.println(secondExp);*/

        String[] bits = exp.split(" \\+ ");
        System.out.println(bits[0]);
        System.out.println(bits[1]);



    }
}