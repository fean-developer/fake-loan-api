package poc_abc.fake_loan_api.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
    @Id
    private String id;
    private String accountNumber;
    private BigDecimal balance;
    private String accountType; // e.g., "SAVINGS", "CHECKING"

    @DBRef
    private User user; // Reference to the User who owns the account
}
