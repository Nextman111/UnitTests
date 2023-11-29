package seminar2.task2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class EmailValidatorTest {

    @ParameterizedTest(name = "Тест email")
    @ValueSource(
            strings = {
                    "das@dasa.ru",
                    "12312312312@aa.ru",
                    "12312312312@aa.r1",
                    "12312312312@.222",
            }
    )
    void isValidEmailTest(String email) {
        var fixture = emailValidator.isValidEmail(email);
        assertTrue(fixture);
    }


    @ParameterizedTest(name = "Тест bad email")
    @ValueSource(
            strings = {
                    "12312312312@",
                    "@.222",
            }
    )
    void isInValidEmailTest(String email) {
        var fixture = emailValidator.isValidEmail(email);
        assertFalse(fixture);
    }

    EmailValidator emailValidator;
    @BeforeEach
    void setUp() {
        emailValidator = new EmailValidator();
    }

    @AfterEach
    void tearDown() {
        emailValidator = null;
    }
}