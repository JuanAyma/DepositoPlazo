package com.bbva.contractmicroservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tasa_interes")
@Entity
public class InterestRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTasaInteres;
    private String tasaInteres;
    private Long idPlazo;
}
