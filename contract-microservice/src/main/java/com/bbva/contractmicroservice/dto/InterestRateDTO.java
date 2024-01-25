package com.bbva.contractmicroservice.dto;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)// si no hay getter ni setter
public class InterestRateDTO {
    private Long idTasaInteres;
    private String tasaInteres;
    private Long idPlazo;
}
