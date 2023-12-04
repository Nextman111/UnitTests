package seminar4.seminar.spy;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceTest {
    @Test
    void testVerifyMethodCall() {
        // Создаем шпионский объект User
        User user = spy(new User());

        // Вызываем метод setName на шпионе
        user.setName("John");

        // Проверяем, был ли вызван метод setName на шпионе ровно один раз
        verify(user).setName("John");

        // Проверяем, что метод getName не был вызван на шпионе
        verify(user, never()).getName();
    }

    @Test
    void testVerifyMethodCallWithTimes() {
        // Создаем шпионский объект User
        User user = spy(new User());

        // Вызываем метод setName на шпионе дважды
        user.setName("John");
        user.setName("Doe");

        // Проверяем, что метод setName был вызван дважды
        verify(user, times(2)).setName(anyString());
    }

    @Test
    void testVerifyMethodCallAtLeastOnce() {
        // Создаем шпионский объект User
        User user = spy(new User());

        // Вызываем метод setName на шпионе хотя бы один раз
        user.setName("John");

        // Проверяем, что метод setName был вызван хотя бы один раз
        verify(user, atLeastOnce()).setName(anyString());
    }
}
    //
//    @Test
//    void testGetUserByIdWithSpy() {
//        // Создаем шпионский объект UserRepository
//        UserRepository userRepository = Mockito.spy(UserRepository.class);
//
//        // Создаем экземпляр UserService, передавая шпионский объект
//        UserService userService = new UserService(userRepository);
//
//        // Задаем ожидаемый результат
//        int userId = 1;
//        User expectedUser = new User(userId, "JohnDoe");
//
//        // Устанавливаем поведение для шпиона: при вызове метода getUserById вернуть ожидаемого пользователя
//        when(userRepository.getUserById(userId)).thenReturn(expectedUser);
//
//        // Вызываем метод getUserById и проверяем, что результат соответствует ожиданиям
//        User user = userService.getUserById(userId);
//        assertEquals(expectedUser, user);
//
//        // Проверяем, что метод getUserById был вызван ровно один раз с правильными аргументами
//        verify(userRepository, times(1)).getUserById(userId);
//    }
//}