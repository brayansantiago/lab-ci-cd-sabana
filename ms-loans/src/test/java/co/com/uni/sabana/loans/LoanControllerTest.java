package co.com.uni.sabana.loans;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LoanControllerTest {

    private LoanController loanController;

    @BeforeEach
    void setUp() {
        loanController = new LoanController();
    }

    @Test
    void testGetAllLoans() {
        List<Loan> loans = loanController.getAllLoans();

        assertNotNull(loans);
        assertEquals(1, loans.size());
        
        Loan initialLoan = loans.get(0);
        assertEquals(1L, initialLoan.id());
        assertEquals(101L, initialLoan.bookId());
        assertEquals("estudiante-001", initialLoan.userId());
    }

    @Test
    void testCreateLoan() {
        Loan newLoan = new Loan(2L, 102L, "estudiante-002", "2026-03-07", "ACTIVE");
        Loan result = loanController.createLoan(newLoan);

        assertNotNull(result);
        assertEquals(2L, result.id());
        
        List<Loan> loans = loanController.getAllLoans();
        assertEquals(2, loans.size());
        assertEquals(newLoan, loans.get(1));
    }

    @Test
    void testHealthCheck() {
        ResponseEntity<String> response = loanController.healthCheck();

        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertTrue(response.getBody().contains("funcionando"));
    }
}
