package net.javabackend.springboot.service;

import net.javabackend.springboot.dto.PuestoDto;

import java.util.List;

public interface PuestoService {
    PuestoDto createPuesto(PuestoDto puestoDto);
    PuestoDto getPuestoById(Long puestoId);
    List<PuestoDto> getAllPuestos();
    PuestoDto updatePuesto(Long puestoId, PuestoDto updatePuesto);
    void deletePuesto(Long puestoId);
}
