package net.javabackend.springboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellidos")
    private String apellidos;
    @Column(name = "Email", nullable = false, unique = true)
    private String email;
    @Column(name = "FechaNacimiento")
    private String fechanacimiento;
    @Column(name = "LugarNacimiento")
    private String lugarnacimiento;
    @Column(name = "Domicilio")
    private String domicilio;
    @Column(name = "IdPuesto")
    private Long idpuesto;
    @Column(name = "IdDepartamento")
    private Long iddepartamento;
    @Column(name = "EsJefe")
    private boolean isJefe;
    @Column(name = "EsSuperJefe")
    private boolean isSuperJefe;
    @Column(name = "IsActivo" )
    private boolean isActivo = true;
}
