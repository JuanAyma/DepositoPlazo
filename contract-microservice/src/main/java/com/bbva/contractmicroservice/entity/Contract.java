package com.bbva.contractmicroservice.entity;

import com.bbva.contractmicroservice.model.Account;
import com.bbva.contractmicroservice.model.InterestRate;
import com.bbva.contractmicroservice.model.Product;
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
@Table(name="contrato")
@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrato;
    private LocalDate fechaInicio;
    private LocalDate fechaVencimiento;
    private String cuentaOrigen;
    private String cuentaDepositoInte;
    private BigDecimal ganancia;

    @OneToOne
    @JoinColumn(name = "idCuenta")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "idTasaInteres")
    private InterestRate interestRate;

    @OneToOne
    @JoinColumn(name = "idProducto")
    private Product product;
}
