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
public class CustomerDTO {

        private Long idCliente;
        private String nombre;
        private String apellido;
        private String celular;
        private String dni;
        private String direccion;
        private String correo;
}
