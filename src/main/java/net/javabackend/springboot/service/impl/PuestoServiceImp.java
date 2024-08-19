package net.javabackend.springboot.service.impl;

import lombok.AllArgsConstructor;
import net.javabackend.springboot.dto.PuestoDto;
import net.javabackend.springboot.entity.Puesto;
import net.javabackend.springboot.exception.ResourceNotFoundException;
import net.javabackend.springboot.mapper.PuestoMapper;
import net.javabackend.springboot.repository.PuestoRepository;
import net.javabackend.springboot.service.PuestoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PuestoServiceImp implements PuestoService {
    private PuestoRepository puestoRepository;

    @Override
    public PuestoDto createPuesto(PuestoDto puestoDto) {
        Puesto puesto = PuestoMapper.mapToPuesto(puestoDto);
        Puesto savePuesto = puestoRepository.save(puesto);
        return PuestoMapper.mapToPuestoDto(savePuesto);
    }

    @Override
    public PuestoDto getPuestoById(Long puestoId) {
        Puesto puesto = puestoRepository.findById(puestoId)
                .orElseThrow(() -> new ResourceNotFoundException("Puesto no existe con ese id"));
        return PuestoMapper.mapToPuestoDto(puesto);
    }

    @Override
    public List<PuestoDto> getAllPuestos() {
        List<Puesto> puestos = puestoRepository.findAll();
        return puestos.stream().map((puesto) -> PuestoMapper.mapToPuestoDto(puesto))
                .collect(Collectors.toList());
    }

    @Override
    public PuestoDto updatePuesto(Long puestoId, PuestoDto updatePuesto) {
        Puesto puesto = puestoRepository.findById(puestoId).orElseThrow(
                () -> new ResourceNotFoundException("Puesto no existente o no encontrado")
        );
        puesto.setNombre(updatePuesto.getNombre());
        puesto.setDescripcion(updatePuesto.getDescripcion());
        puesto.setDepartamentoid(updatePuesto.getDepartamentoid());
        Puesto puestoupdate = puestoRepository.save(puesto);
        return PuestoMapper.mapToPuestoDto(puestoupdate);
    }

    @Override
    public void deletePuesto(Long puestoId) {
        Puesto puesto = puestoRepository.findById(puestoId).orElseThrow(
                () -> new ResourceNotFoundException("Puesto no existente o no encontrado")
        );
        puestoRepository.deleteById(puestoId);
    }
}
