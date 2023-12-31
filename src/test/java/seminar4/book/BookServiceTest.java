package seminar4.book;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


/**
 *
 * 1) Почему использование тестовых заглушек может быть полезным при написании модульных тестов?
 * Для изоляции тестирумого модуля от зависимостей, чтобы проверить его бизнес-логику, достаточно имитировать объекты-зависимости. Это даст скорость выполнения теста, без вмешательства в рабочий код или другие модули системы.
 *
 * 2) Какой тип тестовой заглушки следует использовать, если вам нужно проверить, что метод был вызван с определенными аргументами?
 *
 * Тип mock/spy;
 *
 * 3) Какой тип тестовой заглушки следует использовать, если вам просто нужно вернуть определенное значение или исключение в ответ на вызов метода?
 *  Тип stub/fake
 *
 * 4) Какой тип тестовой заглушки вы бы использовали для имитации взаимодействия с внешним API или базой данных?
 * Тип fake
 *
  */
class BookServiceTest {

    @Test
    void findBookById() {
        /**
         *  В классе BookService есть поле данных с интерфейсом BookRepository
         //       *  имплементацыя в классе InMemoryBookRepository, если сделать просто mock заглушку
         * то не сможем передать и получить данные, т.к. конструктор в нём определёт по умолчанию и нет сеттеров.
         * По этому восполюзуемся моком spy;
         */
        BookRepository bookRepository = spy(InMemoryBookRepository.class);

        // Создаем экземпляр BookService с имитацией BookRepository
        BookService bookService = new BookService(bookRepository);

        // Задаем ожидаемый результат
        Book expected = new Book("2", "Book1", "Author1");

        // параметр метода
        String id = "2";

        // Устанавливаем поведение для шпиона: при вызове метода getUserById вернуть ожидаемого пользователя
        when(bookService.findBookById(id)).thenReturn(expected);


        var condition = bookService.findBookById(id);
        assertEquals(expected, condition);

        // Проверяем, что метод findAll был вызван ровно один раз с правильными аргументами
        verify(bookRepository, times(1)).findById(id);
    }

    @Test
    void findAllBooks() {
        /**
         *  В классе BookService есть поле данных с интерфейсом BookRepository
//       *  имплементацыя в классе InMemoryBookRepository, если сделать просто mock заглушку
         * то не сможем передать и получить данные, т.к. конструктор в нём определёт по умолчанию и нет сеттеров.
         * По этому восполюзуемся моком spy;
         */
        BookRepository bookRepository = spy(InMemoryBookRepository.class);

        // Создаем экземпляр BookService с имитацией BookRepository
        BookService bookService = new BookService(bookRepository);

        // Задаем ожидаемый результат
        List<Book> expected = new ArrayList<>();
        expected.add(new Book("1", "Book1", "Author1"));
        expected.add(new Book("2", "Book2", "Author2"));

        // Устанавливаем поведение для шпиона: при вызове метода getUserById вернуть ожидаемого пользователя
        when(bookService.findAllBooks()).thenReturn(expected);


        var condition = bookService.findAllBooks();
        assertEquals(expected, condition);

        // Проверяем, что метод findAll был вызван ровно один раз с правильными аргументами
        verify(bookRepository, times(1)).findAll();
    }
}