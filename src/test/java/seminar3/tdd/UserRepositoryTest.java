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
        repository.addUser(new User("User1", "pass1", true));
        repository.addUser(new User("User2", "pass2", false));
        repository.addUser(new User("User3", "pass3", false));
        repository.addUser(new User("User4", "pass4", false));
        repository.addUser(new User("User5", "pass5", true));
        repository.addUser(new User("User6", "pass6", false));
        repository.addUser(new User("User7", "pass7", true));



    }
    @Test
    @DisplayName("Кто не админ на выход..")
    void disconnectAllNoAdminsTest() {
        //считаем сами кто не админ
        int expected = 0;
        for (User user: repository.data){
            if (!user.isAdmin()) {
                expected++;
            }
        }

        assertEquals(expected, repository.disconnectAllNoAdmins());
        System.out.println("Вышло " + expected);
    }
}