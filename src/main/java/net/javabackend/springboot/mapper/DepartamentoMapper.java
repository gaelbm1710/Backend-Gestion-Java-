package net.javabackend.springboot.mapper;

import net.javabackend.springboot.dto.DepartamentoDto;
import net.javabackend.springboot.entity.Departamento;

public class DepartamentoMapper {
    public static DepartamentoDto mapToDepartamentoDto(Departamento departamento){
        return new DepartamentoDto(
                departamento.getId(),
                departamento.getNombre(),
                departamento.getDescripcion()
        );
    }
    public static Departamento mapToDepartamento(DepartamentoDto departamentoDto){
        return new Departamento(
                departamentoDto.getId(),
                departamentoDto.getNombre(),
                departamentoDto.getDescripcion()
        );
    }
}
