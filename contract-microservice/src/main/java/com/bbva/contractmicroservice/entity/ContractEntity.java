package com.bbva.contractmicroservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="contrato")
@Entity
public class ContractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrato;
    private Long idCliente;
    private Long idProducto;
    private String fechaInicio;
    private String fechaVencimiento;
    private String cuentaOrigen;
    private String cuentaDepositoInte;
    private String ganancia;
    private Long idInteres;
}
