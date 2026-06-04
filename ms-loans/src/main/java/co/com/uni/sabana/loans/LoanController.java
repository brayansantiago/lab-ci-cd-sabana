package co.com.uni.sabana.loans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final List<Loan> loans = new ArrayList<>();

    public LoanController() {
        loans.add(new Loan(1L, 101L, "estudiante-001", "2026-03-06", "ACTIVE"));
    }

    @GetMapping
    public List<Loan> getAllLoans() {
        return loans;
    }

    @PostMapping
    public Loan createLoan(@RequestBody Loan newLoan) {
        loans.add(newLoan);
        return newLoan;
    }

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Servicio ms-loans funcionando");
    }

}
