package seminar4.seminar.mock;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class EmailServiceTest {

    @Test
    void testSendWelcomeEmailWithMock() {
        // Создаем имитацию (мок) для интерфейса EmailSender
        EmailSender emailSender = mock(EmailSender.class);

        // Создаем экземпляр EmailService с имитацией EmailSender
        EmailService emailService = new EmailService(emailSender);

        // Задаем ожидаемый результат
        String to = "user@example.com";
        String subject = "Добро пожаловать";
        String body = "Добро пожаловать на наш сайт!";

        // Вызываем метод sendWelcomeEmail
        emailService.sendWelcomeEmail(to);

        // Проверяем, что метод sendEmail был вызван с правильными аргументами
        verify(emailSender).sendEmail(to, subject, body);

        // Мы также можем установить другие ожидания и проверки в этом тесте, если это необходимо

        // Пример: Проверка, что метод sendEmail был вызван только один раз
        verify(emailSender, times(1)).sendEmail(anyString(), anyString(), anyString());

        // Пример: Установка ожидания исключения при вызове метода sendEmail
        // метод doThtorw вызовет исключение для метода, when(emailSender) - при вызове / .sendEmail(eq("error@example.com"), anyString(), anyString()) - с такими аргументами, ждем исключения;
        doThrow(new RuntimeException("Ошибка отправки письма")).when(emailSender).sendEmail(eq("error@example.com"), anyString(), anyString());

        // Пример: Проверка, что метод sendEmail не был вызван для конкретного адреса
        verify(emailSender, never()).sendEmail(eq("another@example.com"), anyString(), anyString());

        // Пример: Проверка, что метод sendEmail был вызван с определенными аргументами в определенной последовательности
        // InOrder - позволяет вызывать метод мока с ожиданием аргуметнов в последовательности
        InOrder inOrder = inOrder(emailSender);
        inOrder.verify(emailSender).sendEmail(eq("user@example.com"), anyString(), anyString());
        inOrder.verify(emailSender).sendEmail(eq("admin@example.com"), anyString(), anyString());
    }
}