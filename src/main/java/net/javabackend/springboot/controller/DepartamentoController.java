package net.javabackend.springboot.controller;

import lombok.AllArgsConstructor;
import net.javabackend.springboot.dto.DepartamentoDto;
import net.javabackend.springboot.service.DepartamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {
    private DepartamentoService departamentoService;
    //Post de Departamentos
    @PostMapping
    public ResponseEntity<DepartamentoDto> createDepartamento(@RequestBody DepartamentoDto departamentoDto){
        DepartamentoDto saveDepartamento = departamentoService.createDepartamento(departamentoDto);
        return new ResponseEntity<>(saveDepartamento, HttpStatus.CREATED);
    }
    //Get Departamento by Id
    @GetMapping("{id}")
    public ResponseEntity<DepartamentoDto> getDepartamentoById(@PathVariable("id") Long departamentoId){
        DepartamentoDto departamentoDto = departamentoService.getDepartamentoById(departamentoId);
        return ResponseEntity.ok(departamentoDto);
    }
    //Get all Departamentos
    @GetMapping
    public ResponseEntity<List<DepartamentoDto>> getAllDepartamentos(){
        List<DepartamentoDto> departamentos = departamentoService.gettAllDepartamento();
        return ResponseEntity.ok(departamentos);
    }
    //Update Departamento
    @PutMapping("{id}")
    public ResponseEntity<DepartamentoDto> updateDepartamento(@PathVariable("id") Long departamentoId, @RequestBody DepartamentoDto updateDepartamento){
        DepartamentoDto departamentoDto = departamentoService.updateDepartamento(departamentoId, updateDepartamento);
        return ResponseEntity.ok(departamentoDto);
    }
    //Delete Departamento
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartamento(@PathVariable("id") Long departamentoId){
        departamentoService.deleteDepartamento(departamentoId);
        return ResponseEntity.ok("Departamento Eliminado correctamente");
    }
}
