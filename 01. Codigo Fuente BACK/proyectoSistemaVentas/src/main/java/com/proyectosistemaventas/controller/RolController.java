package com.proyectosistemaventas.controller;

import com.proyectosistemaventas.dtos.RolCreateDTO;
import com.proyectosistemaventas.dtos.RolDTO;
import com.proyectosistemaventas.dtos.RolUpdateDTO;
import com.proyectosistemaventas.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping("/roles")
    public ResponseEntity<List<RolDTO>> listarRoles() {
        return  new ResponseEntity<>(rolService.listarRoles(), HttpStatus.OK);
    }


    @GetMapping("/roles/{rolesId}")
    public ResponseEntity<RolDTO> obtenerRolesPorId(@PathVariable("rolesId") long rolesId){

        return  new ResponseEntity<> ( rolService.obtenerRolPorId(rolesId),HttpStatus.OK);
    }


    @PostMapping("/roles")
    public ResponseEntity<RolDTO> registrarRoles(@RequestBody RolCreateDTO rolCreateDTO){
        return  new ResponseEntity <>( rolService.registrarRol(rolCreateDTO) ,HttpStatus.OK) ;
    }


    @PutMapping("/roles")
    public ResponseEntity<RolDTO> actualizarRoles(@RequestBody RolUpdateDTO rolUpdateDTO){
        return new ResponseEntity<>(rolService.actualizarRol(rolUpdateDTO),HttpStatus.OK);
    }

    @DeleteMapping("/roles/{rolesId}")
    public ResponseEntity<RolDTO> eliminarRoles(@PathVariable("rolesId") long rolesId) {
        return new ResponseEntity<>( rolService.eliminarRol(rolesId),HttpStatus.OK);
    }
}
