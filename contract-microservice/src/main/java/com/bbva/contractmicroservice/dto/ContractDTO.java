package com.bbva.contractmicroservice.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)// si no hay getter ni setter
public class ContractDTO {

    private Long idContrato;
    private LocalDate fechaInicio;
    private LocalDate fechaVencimiento;
    private String cuentaOrigen;
    private String cuentaDepositoInte;
    private BigDecimal ganancia;

    private AccountDTO account;
    private InterestRateDTO interestRate;
    private ProductoDTO product;
}
