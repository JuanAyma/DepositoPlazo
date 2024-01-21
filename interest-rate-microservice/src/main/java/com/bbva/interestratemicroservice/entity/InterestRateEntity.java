package com.bbva.interestratemicroservice.entity;

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
public class InterestRateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTasaInteres;
    private String tasaInteres;
    private Long idPlazo;
}
