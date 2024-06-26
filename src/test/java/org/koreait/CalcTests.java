package org.koreait;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalcTests {

    @Test
    @DisplayName("1 + 1 == 2")
    void t1(){
        assertThat(Calc.run("1 + 1")).isEqualTo(2);
    }
    @Test
    @DisplayName("2 + 1 == 3")
    void t2(){
        assertThat(Calc.run("2 + 1")).isEqualTo(3);
    }
    @Test
    @DisplayName("3 + 1 == 4")
    void t3(){
        assertThat(Calc.run("3 + 1")).isEqualTo(4);
    }
    @Test
    @DisplayName("50 - 30 == 20")
    void t4(){
        assertThat(Calc.run("50 - 30")).isEqualTo(20);
    }
    @Test
    @DisplayName("10 + 20 + 30 == 60")
    void t5(){
        assertThat(Calc.run("10 + 20 + 30")).isEqualTo(60);
    }
    @Test
    @DisplayName("10 - 20 + 30 == 20")
    void t6(){
        assertThat(Calc.run("10 - 20 + 30")).isEqualTo(20);
    }
    @Test
    @DisplayName("10 - 10 - 10 - 10 + 10 + 10 - 10 == -10")
    void t7(){
        assertThat(Calc.run("10 - 10 - 10 - 10 + 10 + 10 - 10")).isEqualTo(-10);
    }
    @Test
    @DisplayName("10 * 10 * 10 == 1000")
    void t8(){
        assertThat(Calc.run("10 * 10 * 10")).isEqualTo(1000);
    }
    @Test
    @DisplayName("10 * -10 == -100")
    void t9(){
        assertThat(Calc.run("10 * -10")).isEqualTo(-100);
    }
    @Test
    @DisplayName("10 + 5 * 2 == 20")
    void t10(){
        assertThat(Calc.run("10 + 5 * 2")).isEqualTo(20);
    }
    @Test
    @DisplayName("20 + 10 + 5 * 2 == 40")
    void t11(){
        assertThat(Calc.run("20 + 10 + 5 * 2")).isEqualTo(40);
    }
    @Test
    @DisplayName("20 * 10 + 5 * 2 == 210")
    void t12(){
        assertThat(Calc.run("20 * 10 + 5 * 2")).isEqualTo(210);
    }
    @Test
    @DisplayName("30 * 10 - 5 * 2 == 290")
    void t13(){
        assertThat(Calc.run("30 * 10 - 5 * 2")).isEqualTo(290);
    }
    @Test
    @DisplayName("(10 + 20) == 30")
    void t14(){
        assertThat(Calc.run("(10 + 20)")).isEqualTo(30);
    }
    @Test
    @DisplayName("((10 + 20)) == 30")
    void t15(){
        assertThat(Calc.run("((10 + 20))")).isEqualTo(30);
    }
    @Test
    @DisplayName("(((10 + 20))) == 30")
    void t16(){
        assertThat(Calc.run("(((10 + 20)))")).isEqualTo(30);
    }
    @Test
    @DisplayName("100 == 100")
    void t17(){
        assertThat(Calc.run("100")).isEqualTo(100);
    }
    @Test
    @DisplayName("(20 + 20) + 20 == 60")
    void t18(){
        assertThat(Calc.run("(20 + 20) + 20")).isEqualTo(60);
    }
    @Test
    @DisplayName("((20 + 20)) + 20 == 60")
    void t19(){
        assertThat(Calc.run("((20 + 20)) + 20")).isEqualTo(60);
    }
    @Test
    @DisplayName("(20 - 20) + 20 + 20 == 40")
    void t20(){
        assertThat(Calc.run("(20 - 20) + 20 + 20")).isEqualTo(40);
    }
    @Test
    @DisplayName("(10 + 20) * 3 == 90")
    void t21(){
        assertThat(Calc.run("(10 + 20) * 3")).isEqualTo(90);
    }
    @Test
    @DisplayName("10 + (10 + 5) == 25")
    void t22(){
        assertThat(Calc.run("10 + (10 + 5)")).isEqualTo(25);
    }
    @Test
    @DisplayName("10 * (10 + 5) == 150")
    void t23(){
        assertThat(Calc.run("10 * (10 + 5)")).isEqualTo(150);
    }
}