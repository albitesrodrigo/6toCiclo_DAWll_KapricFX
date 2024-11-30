package com.proyectosistemaventas.controller;

import com.proyectosistemaventas.dtos.VentasCreateDTO;
import com.proyectosistemaventas.dtos.VentasDTO;
import com.proyectosistemaventas.service.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class VentasController {

    @Autowired
    private VentasService ventasService;

    @GetMapping("ventas")
    public ResponseEntity<List<VentasDTO>> listarVentas(){
        return new ResponseEntity<>(ventasService.listarVentas(), HttpStatus.OK);
    }

    @GetMapping("/ventas/{ventasId}")
    public ResponseEntity<VentasDTO>obtenerVentasPorId(@PathVariable("ventas") long ventasId){
        return new ResponseEntity<>(ventasService.obtenerVentasPorID(ventasId),HttpStatus.OK);
    }

    @PostMapping("ventas")
    public ResponseEntity<VentasDTO> registrarVentas(@RequestBody VentasCreateDTO ventasCreateDTO){
        return new ResponseEntity<>(ventasService.registrarVentas(ventasCreateDTO),HttpStatus.OK);
    }

}
