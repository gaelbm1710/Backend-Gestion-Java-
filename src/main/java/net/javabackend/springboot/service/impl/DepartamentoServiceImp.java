package net.javabackend.springboot.service.impl;


import lombok.AllArgsConstructor;
import net.javabackend.springboot.dto.DepartamentoDto;
import net.javabackend.springboot.entity.Departamento;
import net.javabackend.springboot.exception.ResourceNotFoundException;
import net.javabackend.springboot.mapper.DepartamentoMapper;
import net.javabackend.springboot.repository.DepartamentoRepository;
import net.javabackend.springboot.service.DepartamentoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartamentoServiceImp implements DepartamentoService {
    private DepartamentoRepository departamentoRepository;

    @Override
    public DepartamentoDto createDepartamento(DepartamentoDto departamentoDto) {
        Departamento departamento = DepartamentoMapper.mapToDepartamento(departamentoDto);
        Departamento saveDepartamento = departamentoRepository.save(departamento);
        return DepartamentoMapper.mapToDepartamentoDto(saveDepartamento);
    }

    @Override
    public DepartamentoDto getDepartamentoById(Long departamentoId) {
        Departamento departamento = departamentoRepository.findById(departamentoId)
                .orElseThrow(() -> new ResourceNotFoundException("Departamento no encontrado"));
        return DepartamentoMapper.mapToDepartamentoDto(departamento);
    }

    @Override
    public List<DepartamentoDto> gettAllDepartamento() {
        List<Departamento> departamentos = departamentoRepository.findAll();
        return departamentos.stream().map((departamento) -> DepartamentoMapper.mapToDepartamentoDto(departamento))
                .collect(Collectors.toList());
    }

    @Override
    public DepartamentoDto updateDepartamento(Long departamentoId, DepartamentoDto updateDepartamento) {
        Departamento departamento = departamentoRepository.findById(departamentoId).orElseThrow(
                () -> new ResourceNotFoundException("Departamento no existe o no encontrado")
        );
        departamento.setNombre(updateDepartamento.getNombre());
        departamento.setDescripcion(updateDepartamento.getDescripcion());
        Departamento departamentoupdate = departamentoRepository.save(departamento);
        return DepartamentoMapper.mapToDepartamentoDto(departamentoupdate);
    }

    @Override
    public void deleteDepartamento(Long departamentoId) {
        Departamento departamento = departamentoRepository.findById(departamentoId).orElseThrow(
                () -> new ResourceNotFoundException("Departamento no existe o no encontrado")
        );
        departamentoRepository.deleteById(departamentoId);
    }
}
