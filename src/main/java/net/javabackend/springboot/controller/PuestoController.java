package net.javabackend.springboot.controller;

import lombok.AllArgsConstructor;
import net.javabackend.springboot.dto.PuestoDto;
import net.javabackend.springboot.service.PuestoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/puestos")
public class PuestoController {
    private PuestoService puestoService;
    //Post de Puestos
    @PostMapping
    public ResponseEntity<PuestoDto> createPuesto(@RequestBody PuestoDto puestoDto){
        PuestoDto savePuesto = puestoService.createPuesto(puestoDto);
        return new ResponseEntity<>(savePuesto, HttpStatus.CREATED);
    }
    //Get Puesto by Id
    @GetMapping("{id}")
    public ResponseEntity<PuestoDto> getPuestoById(@PathVariable("id") Long puestoId){
        PuestoDto puestoDto = puestoService.getPuestoById(puestoId);
        return ResponseEntity.ok(puestoDto);
    }
    //Get all Puestos
    @GetMapping
    public ResponseEntity<List<PuestoDto>> getAllPuestos(){
        List<PuestoDto> puestos = puestoService.getAllPuestos();
        return ResponseEntity.ok(puestos);
    }
    //Update Puesto
    @PutMapping("{id}")
    public ResponseEntity<PuestoDto> updatePuesto(@PathVariable("id") Long puestoId, @RequestBody PuestoDto updatePuesto){
        PuestoDto puestoDto = puestoService.updatePuesto(puestoId, updatePuesto);
        return ResponseEntity.ok(puestoDto);
    }
    //Delete Puesto
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePuesto(@PathVariable("id") Long puestoId){
        puestoService.deletePuesto(puestoId);
        return ResponseEntity.ok("Puesto Eliminado" + HttpStatus.OK);
    }
}
