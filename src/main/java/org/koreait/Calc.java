package org.koreait;

import java.util.Arrays;

public class Calc {
    public static int run(String exp) {

        boolean needToPlusMinus = exp.contains("+") || exp.contains("-");
        boolean needToMultiple = exp.contains("*");

        if(needToPlusMinus) {
            exp = exp.replaceAll("- ", "+ -"); //필터링 하는 역할
            String[] bits = exp.split(" \\+ ");
            int rs = 0;
            for(int i = 0; i < bits.length; i++) {
                rs += Integer.parseInt(bits[i]);
            }
            return rs;
        }
        else if(needToMultiple) {
            String[] bits = exp.split(" \\* ");
            int rs = 1;
            for(int i = 0; i < bits.length; i++) {
                rs *= Integer.parseInt(bits[i]);
            }
            return rs;
        }

        return 0;


        //throw new RuntimeException("해석불가");
    }
}