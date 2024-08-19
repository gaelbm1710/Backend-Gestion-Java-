package net.javabackend.springboot.service.impl;

import lombok.AllArgsConstructor;
import net.javabackend.springboot.dto.EmpleadoDto;
import net.javabackend.springboot.entity.Empleado;
import net.javabackend.springboot.exception.ResourceNotFoundException;
import net.javabackend.springboot.mapper.EmpleadoMapper;
import net.javabackend.springboot.repository.EmpleadoRepository;
import net.javabackend.springboot.service.EmpleadoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmpleadoServiceImp implements EmpleadoService {
    private EmpleadoRepository empleadoRepository;

    @Override
    public EmpleadoDto createEmpleado(EmpleadoDto empleadoDto) {
        Empleado empleado = EmpleadoMapper.mapToEmpleado(empleadoDto);
        Empleado saveEmpleado = empleadoRepository.save(empleado);
        return EmpleadoMapper.mapToEmpleadoDto(saveEmpleado);
    }

    @Override
    public EmpleadoDto getEmpleadoById(Long empleadoId) {
       Empleado empleado = empleadoRepository.findById(empleadoId)
               .orElseThrow(() -> new ResourceNotFoundException("Empleado no existe con ese id"));
               return EmpleadoMapper.mapToEmpleadoDto(empleado);
    }

    @Override
    public List<EmpleadoDto> getAllEmpleados() {
        List<Empleado> empleados = empleadoRepository.findAll();
        return empleados.stream().map((empleado) -> EmpleadoMapper.mapToEmpleadoDto(empleado))
                .collect(Collectors.toList());
    }

    @Override
    public EmpleadoDto updateEmpleado(Long empleadoId, EmpleadoDto updateEmpleado) {
        Empleado empleado = empleadoRepository.findById(empleadoId).orElseThrow(
                () -> new ResourceNotFoundException("Empleado no existe o no encontrado")
        );
        empleado.setNombre(updateEmpleado.getNombre());
        empleado.setApellidos(updateEmpleado.getApellidos());
        empleado.setEmail(updateEmpleado.getEmail());
        empleado.setFechanacimiento(updateEmpleado.getFechanacimiento());
        empleado.setLugarnacimiento(updateEmpleado.getLugarnacimiento());
        empleado.setDomicilio(updateEmpleado.getDomicilio());
        empleado.setIdpuesto(updateEmpleado.getIdpuesto());
        empleado.setIddepartamento(updateEmpleado.getIddepartamento());
        empleado.setJefe(updateEmpleado.isJefe());
        empleado.setSuperJefe(updateEmpleado.isSuperJefe());
        empleado.setActivo(updateEmpleado.isActivo());
        Empleado empleadoupdate = empleadoRepository.save(empleado);


        return EmpleadoMapper.mapToEmpleadoDto(empleadoupdate);
    }

    @Override
    public void deleteEmpleado(Long empleadoId) {
        Empleado empleado = empleadoRepository.findById(empleadoId).orElseThrow(
                () -> new ResourceNotFoundException("Empleado no existe o no encontrado")
        );
        empleadoRepository.deleteById(empleadoId);
    }
}
