package seminar3.tdd;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {
    private UserRepository repository;

    @BeforeEach
    void setup(){
        repository = new UserRepository();
    }
    @ParameterizedTest
    @DisplayName("Админ ли ты?")
    @CsvSource({
                        "User1, pass1, true",
                        "User1, pass1, false",
               })
    void isAdmin(String name, String password, boolean isAdmin) {
        boolean expected = isAdmin;
        repository.addUser(new User(name,password,isAdmin));
        assertEquals(expected, repository.data.get(0).isAdmin());
        System.out.println(expected?"Админ!":"Не Админ!");
    }
}