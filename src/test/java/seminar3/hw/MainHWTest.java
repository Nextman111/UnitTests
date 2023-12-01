package seminar3.hw;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MainHWTest {

    @ParameterizedTest
    @DisplayName("Проверка на знак")
    @ValueSource(ints = {-1, 0, 1})
    void isPositiveTest(int n) {
        boolean expected = !(n < 0);
        assertEquals(expected, MainHW.isPositive(n));
        System.out.println(expected ? "Положительное" : "Отрицательное");
    }


    @ParameterizedTest
    @DisplayName("Проверка интервала")
    @ValueSource(ints = {-1, 15, 25, 26, 99, 100, 101})
    void inIntervalTest(int n) {
        boolean expected = n > 25 && n < 100;
        assertEquals(expected, MainHW.inInterval(n));
        System.out.println(expected ? "Входит" : "Выходит");
    }
}