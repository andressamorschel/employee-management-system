package com.br.control.hours.model.domain;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class PaymentsDomain {

    @Id
    private String id;

    @Indexed(unique = true)
    private String paymentId;

    private String employeeId;

    private BigDecimal paymentAmount;

    private BigDecimal INSSAmount;

    private BigDecimal IRRPFAmount;
}
