package poc_abc.fake_loan_api.commons;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class LoanRequest {

    private String accountId;
    private BigDecimal amount;
    private int installments; 
}
