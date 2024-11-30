package com.proyectosistemaventas.controller;

import com.proyectosistemaventas.dtos.EstadoCreateDTO;
import com.proyectosistemaventas.dtos.EstadoDTO;
import com.proyectosistemaventas.dtos.EstadoUpdateDTO;
import com.proyectosistemaventas.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping("estados")
    public ResponseEntity<List<EstadoDTO>> listarEstados(){
        return   new ResponseEntity<>(estadoService.listarEstados(), HttpStatus.OK);
    }

    @GetMapping("/estados/{estadoId}")
    public ResponseEntity<EstadoDTO> obtenerEstadoPorId(@PathVariable("estadoId") long estadoId){
        return  new ResponseEntity<> ( estadoService.obtenerEstadoPorID(estadoId),HttpStatus.OK);
    }

    @PostMapping("estados")
    public ResponseEntity<EstadoDTO> registrarEstado(@RequestBody EstadoCreateDTO estadoCreateDTO){
        return  new ResponseEntity <>( estadoService.registrarEstado(estadoCreateDTO) ,HttpStatus.OK) ;
    }

    @PutMapping("estados")
    public ResponseEntity<EstadoDTO> actualizarEstado(@RequestBody EstadoUpdateDTO estadoUpdateDTO){
        return new ResponseEntity<>(estadoService.actualizarEstado(estadoUpdateDTO),HttpStatus.OK);
    }

    @DeleteMapping("/estados/{estadoId}")
    public ResponseEntity<EstadoDTO> eliminarEstado(@PathVariable("estadoId") long estadoId) {
        return new ResponseEntity<>( estadoService.eliminarEstado(estadoId),HttpStatus.OK);
    }

}
