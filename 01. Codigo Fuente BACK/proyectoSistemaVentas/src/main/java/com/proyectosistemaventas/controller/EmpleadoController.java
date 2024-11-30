package com.proyectosistemaventas.controller;

import com.proyectosistemaventas.dtos.EmpleadoCreateDTO;
import com.proyectosistemaventas.dtos.EmpleadoDTO;
import com.proyectosistemaventas.dtos.EmpleadoUpdateDTO;
import com.proyectosistemaventas.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("empleados")
    public ResponseEntity<List<EmpleadoDTO>>listarEmpleado(){
        return new ResponseEntity<>(empleadoService.listarEmpleado(), HttpStatus.OK);
    }

    @GetMapping("/empleados/{empleadoId}")
    public  ResponseEntity<EmpleadoDTO> obtenerEmpleadoPorId(@PathVariable("empleadoId")long empleadoId){
        return new ResponseEntity<>(empleadoService.obtenerEmpleadoPorID(empleadoId),HttpStatus.OK);
    }
    @PostMapping("empleados")
    public ResponseEntity<EmpleadoDTO>registrarEmpleado(@RequestBody EmpleadoCreateDTO empleadoCreateDTO){
        return  new ResponseEntity<>(empleadoService.registrarEmpleado(empleadoCreateDTO),HttpStatus.OK);
    }

    @PutMapping("empleados")
    public ResponseEntity<EmpleadoDTO> actualizarEmpleado(@RequestBody EmpleadoUpdateDTO empleadoUpdateDTO){
        return  new ResponseEntity<>(empleadoService.actualizarEmpleado(empleadoUpdateDTO),HttpStatus.OK);
    }

    @DeleteMapping("/empleados/{empleadoId}")
    public ResponseEntity<EmpleadoDTO>eliminarEmpleado(@PathVariable("empleadoId") long empleadoId){
        return new ResponseEntity<>(empleadoService.eliminarEmpleado(empleadoId),HttpStatus.OK);
    }

}
