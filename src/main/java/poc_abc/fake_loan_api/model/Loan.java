package poc_abc.fake_loan_api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "loans")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Loan {
    @Id
    private String id;
    private BigDecimal amount;
    private int installments; // Number of installments for the loan
    private LocalDate startDate;
    private LocalDate endDate;
    private String status; // e.g., "ACTIVE", "PAID", "DEFAULTED"

    @DBRef
    private Account account; // Reference to the Account associated with the loan
}
