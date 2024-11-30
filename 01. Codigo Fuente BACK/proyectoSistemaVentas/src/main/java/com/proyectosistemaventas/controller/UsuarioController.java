package com.proyectosistemaventas.controller;

import com.proyectosistemaventas.dtos.UsuarioCreateDTO;
import com.proyectosistemaventas.dtos.UsuarioDTO;
import com.proyectosistemaventas.dtos.UsuarioUpdateDTO;
import com.proyectosistemaventas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("usuarios")
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios(){
        return   new ResponseEntity<>(usuarioService.listarUsuarios(), HttpStatus.OK);
    }

    @GetMapping("/usuarios/{usuarioId}")
    public ResponseEntity<UsuarioDTO> obtenerUsuarioPorId(@PathVariable("usuarioId") long usuarioId){
        return new ResponseEntity<>(usuarioService.obtenerUsuarioPorID(usuarioId), HttpStatus.OK);
    }

    @PostMapping("usuarios")
    public ResponseEntity<UsuarioDTO> registrarUsuario(@RequestBody UsuarioCreateDTO usuarioCreateDTO){
        return  new ResponseEntity <>( usuarioService.registrarUsuario(usuarioCreateDTO) ,HttpStatus.OK) ;
    }

    @PutMapping("usuarios")
    public ResponseEntity<UsuarioDTO> actualizarUsuario(@RequestBody UsuarioUpdateDTO usuarioUpdateDTO){
        return new ResponseEntity<>(usuarioService.actualizarUsuario(usuarioUpdateDTO),HttpStatus.OK);
    }

    @DeleteMapping("/usuarios/{usuarioId}")
    public ResponseEntity<UsuarioDTO> eliminarAutomovil(@PathVariable("usuarioId") long usuarioId) {
        return new ResponseEntity<>( usuarioService.eliminarUsuario(usuarioId),HttpStatus.OK);
    }

}
