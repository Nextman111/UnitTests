package seminar4.book;

import org.junit.jupiter.api.Test;
import seminar4.seminar.mock.EmailSender;
import seminar4.seminar.mock.EmailService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class BookServiceTest {

    @Test
    void findBookById() {
    }

    @Test
    void findAllBooks() {
        // Создаем имитацию (мок) для интерфейса BookRepository,
        // у нас есть имплиментация в классе InMemoryBookRepository
        // для поля bookRepository
//        InMemoryBookRepository bookRepository = mock(InMemoryBookRepository.class);
        InMemoryBookRepository bookRepository = new InMemoryBookRepository();

        // Создаем экземпляр BookService с имитацией BookRepository
        BookService bookService = new BookService(bookRepository);

        // Задаем ожидаемый результат
//        String to = "user@example.com";
//        String subject = "Добро пожаловать";
//        String body = "Добро пожаловать на наш сайт!";

        var res = bookService.findAllBooks();
        System.out.println(res);
    }
}