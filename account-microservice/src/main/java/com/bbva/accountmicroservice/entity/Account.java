package com.bbva.accountmicroservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import com.bbva.accountmicroservice.entity.Currency;
import com.bbva.accountmicroservice.entity.Customer;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Cuenta")
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCuenta;
    @Column(name="saldo")
    private BigDecimal saldo;
    @Column(name="fechaApertura")
    private LocalDate fechaApertura;
    @Column(name="estadoCuenta")
    private String estadoCuenta;


    @ManyToOne
    @JoinColumn(name = "idCliente")// name="id_cliente" -> nombre de la columna en la tabla
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "idMoneda")
    private Currency currency;

}