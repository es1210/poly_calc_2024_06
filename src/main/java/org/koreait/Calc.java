package org.koreait;
public class Calc {
    public static int run(String exp) {
        //괄호 제거
        exp = strpOuterBrackets(exp);


        boolean needToMulti = exp.contains("*");
        boolean needToPlus = exp.contains("+") || exp.contains(" - ");
        boolean needToCompound = needToMulti && needToPlus;

        if (needToCompound) {
            exp = exp.replaceAll("- ", "+ -");
            String[] bits = exp.split(" \\+ ");
            int rs = 0;
            for(int i = 0; i < bits.length; i++) {
                rs += run(bits[i]); // 재귀함수 사용
            }
            return rs;
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

    private static String strpOuterBrackets(String exp) {
        int outerBracketsCount = 0;

        while (exp.charAt(outerBracketsCount) == '(' && exp.charAt(exp.length()-1-outerBracketsCount) == ')'){
            outerBracketsCount++;
        }
        if(outerBracketsCount == 0){}
        return exp.substring(outerBracketsCount, exp.length() - outerBracketsCount);
    }
}