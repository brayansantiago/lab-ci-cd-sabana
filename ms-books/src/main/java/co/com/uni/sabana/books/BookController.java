package co.com.uni.sabana.books;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @GetMapping
    public List<Map<String, Object>> getBooks() {
        return List.of(
            Map.of("id", 1, "titulo", "El señor de los anillos", "autor", "J.R.R. Tolkien"),
            Map.of("id", 2, "titulo", "Cien años de soledad", "autor", "Gabriel García Márquez"),
            Map.of("id", 3, "titulo", "1984", "autor", "George Orwell"),
            Map.of("id", 4, "titulo", "Thor", "autor", "Anonimo 543453")
        );
    }

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Servicio ms-books funcionando para bien");
    }
}
