package com.bbva.costumermicroservice.model;

import jakarta.persistence.*;
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

public class Account {

    private Long idCuenta;

    private BigDecimal saldo;
    private LocalDate fechaApertura;
    private String estadoCuenta;

    private Long idCliente;
    private Long idMoneda;

}
