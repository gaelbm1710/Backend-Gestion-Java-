package net.javabackend.springboot.controller;


import lombok.AllArgsConstructor;
import net.javabackend.springboot.dto.EmpleadoDto;
import net.javabackend.springboot.service.EmpleadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {
    private EmpleadoService empleadoService;
    //Post de Empleados
    @PostMapping
    public ResponseEntity<EmpleadoDto> createEmpleado(@RequestBody EmpleadoDto empleadoDto){
        EmpleadoDto saveEmpleado = empleadoService.createEmpleado(empleadoDto);
        return new ResponseEntity<>(saveEmpleado, HttpStatus.CREATED);
    }
    //Get Empleado by Id
    @GetMapping("{id}")
    public ResponseEntity<EmpleadoDto> getEmpleadoById(@PathVariable("id") Long empleadoId){
        EmpleadoDto empleadoDto = empleadoService.getEmpleadoById(empleadoId);
        return ResponseEntity.ok(empleadoDto);
    }
    //Get all Empleados
    @GetMapping
    public ResponseEntity<List<EmpleadoDto>> getAllEmpleados(){
        List<EmpleadoDto> empleados = empleadoService.getAllEmpleados();
        return ResponseEntity.ok(empleados);
    }
    //Update Empleado
    @PutMapping("{id}")
    public ResponseEntity<EmpleadoDto> updateEmpleado(@PathVariable("id") Long empleadoId, @RequestBody EmpleadoDto updateEmpleado){
        EmpleadoDto empleadoDto = empleadoService.updateEmpleado(empleadoId, updateEmpleado);
        return ResponseEntity.ok(empleadoDto);
    }
    //Delete Empleado
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmpleado(@PathVariable("id") Long empleadoId){
        empleadoService.deleteEmpleado(empleadoId);
        return ResponseEntity.ok("Empleado Eliminado correctamente");
    }
}
