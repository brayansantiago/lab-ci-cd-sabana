package co.com.uni.sabana.books;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookControllerTest {

    private BookController bookController;

    @BeforeEach
    void setUp() {
        bookController = new BookController();
    }

    @Test
    void testGetBooks() {
        List<Map<String, Object>> books = bookController.getBooks();

        assertNotNull(books);
        assertEquals(4, books.size());
        
        Map<String, Object> firstBook = books.get(0);
        assertEquals(1, firstBook.get("id"));
        assertEquals("El señor de los anillos", firstBook.get("titulo"));
        assertEquals("J.R.R. Tolkien", firstBook.get("autor"));
    }

    @Test
    void testHealthCheck() {
        ResponseEntity<String> response = bookController.healthCheck();

        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertTrue(response.getBody().contains("funcionando"));
    }
}
