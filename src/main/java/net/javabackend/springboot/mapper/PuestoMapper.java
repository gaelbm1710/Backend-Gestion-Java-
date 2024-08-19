package net.javabackend.springboot.mapper;

import net.javabackend.springboot.dto.PuestoDto;
import net.javabackend.springboot.entity.Puesto;

public class PuestoMapper {
    public static PuestoDto mapToPuestoDto(Puesto puesto){
        return new PuestoDto(
                puesto.getId(),
                puesto.getNombre(),
                puesto.getDescripcion(),
                puesto.getDepartamentoid()
        );
    }
    public static Puesto mapToPuesto(PuestoDto puestodto){
        return new Puesto(
                puestodto.getId(),
                puestodto.getNombre(),
                puestodto.getDescripcion(),
                puestodto.getDepartamentoid()
        );
    }
}
