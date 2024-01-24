package com.bbva.costumermicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

        private Long idCliente;
        private String nombre;
        private String apellido;
        private String celular;
        private String dni;
        private String direccion;
        private String correo;
}
