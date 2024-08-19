package net.javabackend.springboot.mapper;


import net.javabackend.springboot.dto.EmpleadoDto;
import net.javabackend.springboot.entity.Empleado;

public class EmpleadoMapper {
    public static EmpleadoDto mapToEmpleadoDto(Empleado empleado){
        return new EmpleadoDto(
                empleado.getId(),
                empleado.getNombre(),
                empleado.getApellidos(),
                empleado.getEmail(),
                empleado.getFechanacimiento(),
                empleado.getLugarnacimiento(),
                empleado.getDomicilio(),
                empleado.getIdpuesto(),
                empleado.getIddepartamento(),
                empleado.isJefe(),
                empleado.isSuperJefe(),
                empleado.isActivo()
        );
    }
    public static Empleado mapToEmpleado(EmpleadoDto empleadoDto){
        return new Empleado(
                empleadoDto.getId(),
                empleadoDto.getNombre(),
                empleadoDto.getApellidos(),
                empleadoDto.getEmail(),
                empleadoDto.getFechanacimiento(),
                empleadoDto.getLugarnacimiento(),
                empleadoDto.getDomicilio(),
                empleadoDto.getIdpuesto(),
                empleadoDto.getIddepartamento(),
                empleadoDto.isJefe(),
                empleadoDto.isSuperJefe(),
                empleadoDto.isActivo()
        );
    }
}
