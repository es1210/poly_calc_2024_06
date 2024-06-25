package org.koreait;
public class Calc {
    public static int run(String exp) {
        boolean needToMulti = exp.contains("*");
        boolean needToPlus = exp.contains("+") || exp.contains(" - ");
        boolean needToCompound = needToMulti && needToPlus;

        if (needToCompound) {
            String[] bits = exp.split(" \\+ ");
            int rs = 0;
            for(int i = 1; i < bits.length; i++) {
                rs += run(bits[i]);
            }
            return Integer.parseInt(bits[0]) + rs;
        }

        if (needToPlus) {
            exp = exp.replaceAll("- ", "+ -");

            String[] bits = exp.split(" \\+ ");
            int sum = 0;
            for (int i = 0; i < bits.length; i++) {
                sum += Integer.parseInt(bits[i]);
            }
            return sum;
        } else if (needToMulti) {
            String[] bits = exp.split(" \\* ");
            int sum = 1;
            for (int i = 0; i < bits.length; i++) {
                sum *= Integer.parseInt(bits[i]);
            }
            return sum;
        }
        else{
            return Integer.parseInt(exp);
        }
        //throw new RuntimeException("해석 불가 : 올바른 계산식이 아니야");
    }
}