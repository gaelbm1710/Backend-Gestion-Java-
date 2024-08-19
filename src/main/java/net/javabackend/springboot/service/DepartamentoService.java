package net.javabackend.springboot.service;


import net.javabackend.springboot.dto.DepartamentoDto;

import java.util.List;

public interface DepartamentoService {
    DepartamentoDto createDepartamento(DepartamentoDto departamentoDto);
    DepartamentoDto getDepartamentoById(Long departamentoId);
    List<DepartamentoDto> gettAllDepartamento();
    DepartamentoDto updateDepartamento(Long departamentoId, DepartamentoDto updateDepartamento);
    void deleteDepartamento(Long departamentoId);

}
