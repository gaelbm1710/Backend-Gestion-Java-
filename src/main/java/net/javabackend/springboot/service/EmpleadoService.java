package net.javabackend.springboot.service;

import net.javabackend.springboot.dto.EmpleadoDto;

import java.util.List;

public interface EmpleadoService {
    EmpleadoDto createEmpleado(EmpleadoDto empleadoDto);
    EmpleadoDto getEmpleadoById(Long empleadoId);
    List<EmpleadoDto> getAllEmpleados();
    EmpleadoDto updateEmpleado(Long empleadoId, EmpleadoDto updateEmpleado);
    void deleteEmpleado(Long empleadoId);
}
