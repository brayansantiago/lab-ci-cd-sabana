package co.com.uni.sabana.loans;

public record Loan(Long id, Long bookId, String userId, String loanDate, String status) {
}