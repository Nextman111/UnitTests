package seminar2.task1;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
/**
Напишите тесты с использованием ассертов assertEquals, assertTrue, assertFalse, assertNull, assertNotNull и проверьте работу методов на различных наборах данных.
*/
class MathUtilsTest {


    /*** Тест метода add */
    @ParameterizedTest
    @CsvSource(value = {
            "1, 2",
            "-1, 3",
            "5, 10000"
        }
    )
    @DisplayName("Тест метода add")
    void addTest(int a, int b) {
        assertEquals( a+b, mathUtils.add(a ,b));
    }


    /*** Тест метода subtract */
    @ParameterizedTest
    @CsvSource(value = {
            "1, 2",
            "-1, 3",
            "5, 10000"
        }
    )
    @DisplayName("Тест метода subtract")
    void subtractTest(int a, int b) {
        assertEquals(a-b, mathUtils.subtract(a ,b));
    }

    /*** Тест метода multiply */
    @ParameterizedTest
    @CsvSource(value = {
            "1, 2",
            "-1, 3",
            "5, 10000"
        }
    )
    @DisplayName("Тест метода multiply")
    void multiplyTest(int a, int b) {
        assertEquals(a*b, mathUtils.multiply(a ,b));
    }

    /*** Тест метода divide */
    @ParameterizedTest
    @CsvSource(value = {
            "1, 2",
            "-1, 3",
            "0, 60",
            "5, 10000",
    }
    )
    @DisplayName("Тест метода divide")
    void divideTest(int a, int b) {

        var fixture = mathUtils.divide(a ,b);

        assertEquals((double) a/b, fixture);
        assertTrue((Double)fixture instanceof Double);
    }

    /** Тест деления на ноль */
    @ParameterizedTest
    @CsvSource(value = {
            "1, 0",
        }
    )
    @DisplayName("Тест деления на ноль")
    void divideByZeroTest(int a, int b) {
        assertThatThrownBy(() -> mathUtils.divide(a,b)).isInstanceOf(IllegalAccessError.class).describedAs("Division by zero is not allowed");
    }

    /** Тестируемый модуль */
    private MathUtils mathUtils;

    /** Инициализация объекта тестирования перед каждым тестом */
    @Test
    @BeforeEach
    void setup(){
        mathUtils = new MathUtils();
    }

    /** Обнуление объекта тестирования после каждого теста*/
    @Test
    @AfterEach
    void teardown(){
        mathUtils = null;
    }
}