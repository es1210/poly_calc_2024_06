package org.koreait;

public class Calc {
    public static int run(String exp) {
        //괄호 제거
        exp = strpOuterBrackets(exp);
        exp = exp.trim(); //양 옆에 쓸데없는 공백 제거

        //단일항 들어오면 바로 리턴
        if (!exp.contains(" ")) {
            return Integer.parseInt(exp);
        }

        boolean needToMulti = exp.contains("*");
        boolean needToPlus = exp.contains("+") || exp.contains(" - ");
        boolean needToCompound = needToMulti && needToPlus;
        boolean needToSplit = exp.contains("(") || exp.contains(")");

        if (needToSplit) {
            int bracketsCount = 0;
            int splitPointIndex = -1;

            for (int i = 0; i < exp.length(); i++) {
                if (exp.charAt(i) == '(') {
                    bracketsCount++;
                }
                else if (exp.charAt(i) == ')') {
                    bracketsCount--;
                }
                if (bracketsCount == 0) {
                    splitPointIndex = i;
                    break;
                }
            }
            String firstExp = exp.substring(0, splitPointIndex + 1);
            String secondExp = exp.substring(splitPointIndex + 4);

            return Calc.run(firstExp) + Calc.run(secondExp);
        }

        if (needToCompound) {
            exp = exp.replaceAll("- ", "+ -");
            String[] bits = exp.split(" \\+ ");
            int rs = 0;
            for (int i = 0; i < bits.length; i++) {
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
        } else {
            return Integer.parseInt(exp);
        }
        //throw new RuntimeException("해석 불가 : 올바른 계산식이 아니야");
    }

    private static String strpOuterBrackets(String exp) {
        int outerBracketsCount = 0;

        while (exp.charAt(outerBracketsCount) == '(' && exp.charAt(exp.length() - 1 - outerBracketsCount) == ')') {
            outerBracketsCount++;
        }
        if (outerBracketsCount == 0) {
        }
        return exp.substring(outerBracketsCount, exp.length() - outerBracketsCount);
    }
}