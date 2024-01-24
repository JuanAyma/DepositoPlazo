package com.bbva.contractmicroservice.dto;

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
public class ContractDTO {
    private Long idContrato;
    /*private Long idCuenta;
    private Long idProducto;*/
    private LocalDate fechaInicio;
    private LocalDate fechaVencimiento;
    private String cuentaOrigen;
    private String cuentaDepositoInte;
    private BigDecimal ganancia;
    //private Long idInteres;

    private AccountDTO account;
    private ProductoDTO producto;
    private InterestRateDTO interes;
}
