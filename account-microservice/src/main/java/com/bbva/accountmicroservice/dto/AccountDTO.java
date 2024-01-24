package com.bbva.accountmicroservice.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)// si no hay getter ni setter
public class AccountDTO {
    private Long idCuenta;
    private BigDecimal saldo;
    private LocalDate fechaApertura;
    private String estadoCuenta;

    private CustomerDTO customer;
    private CurrencyDTO currency;

}
