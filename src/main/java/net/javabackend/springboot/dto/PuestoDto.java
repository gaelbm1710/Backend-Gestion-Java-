package net.javabackend.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PuestoDto {
    private Long id;
    private String nombre;
    private String descripcion;
    private Long departamentoid;
}
