package com.bbva.accountmicroservice.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)// si no hay getter ni setter
public class CurrencyDTO {
    private Long idMoneda;
    private String nombreMoneda;
    private String simbolo;
}
