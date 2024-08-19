package net.javabackend.springboot.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoDto {
    private Long id;
    private String nombre;
    private String apellidos;
    private String email;
    private String fechanacimiento;
    private String lugarnacimiento;
    private String domicilio;
    private Long idpuesto;
    private Long iddepartamento;
    private boolean isJefe;
    private boolean isSuperJefe;
    private boolean isActivo = true;
}
