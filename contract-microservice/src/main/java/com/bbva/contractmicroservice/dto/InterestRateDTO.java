package com.bbva.contractmicroservice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InterestRateDTO {
    private Long idTasaInteres;
    private String tasaInteres;
    private Long idPlazo;
}
