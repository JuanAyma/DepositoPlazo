package com.bbva.accountmicroservice.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)// si no hay getter ni setter
public class AccountCreateDTO {

    private Long idCuenta;
    private BigDecimal saldo;
    private LocalDate fechaApertura;
    private String estadoCuenta;
    private Long idCliente;
    private Long idMoneda;

}
