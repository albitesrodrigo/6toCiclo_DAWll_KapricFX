package com.proyectosistemaventas.controller;

import com.proyectosistemaventas.dtos.TipoDocumentoCreateDTO;
import com.proyectosistemaventas.dtos.TipoDocumentoDTO;
import com.proyectosistemaventas.dtos.TipoDocumentoUpdateDTO;
import com.proyectosistemaventas.service.TipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class TipoDocumentoController {

    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @GetMapping("tipodocumentos")
    public ResponseEntity<List<TipoDocumentoDTO>> listarTipoDocumentos(){
        return   new ResponseEntity<>(tipoDocumentoService.listarTipoDocumentos(), HttpStatus.OK);
    }

    @GetMapping("/tipodocumentos/{tipodocumentoId}")
    public ResponseEntity<TipoDocumentoDTO> obtenerTipoDocumentoPorId(@PathVariable("tipodocumentoId") long tipodocumentoId){
        return  new ResponseEntity<> ( tipoDocumentoService.obtenerTipoDocumentoPorID(tipodocumentoId),HttpStatus.OK);
    }

    @PostMapping("tipodocumentos")
    public ResponseEntity<TipoDocumentoDTO> registrarTipoDocumento(@RequestBody TipoDocumentoCreateDTO tipoDocumentoCreateDTO){
        return  new ResponseEntity <>( tipoDocumentoService.registrarTipoDocumento(tipoDocumentoCreateDTO) ,HttpStatus.OK) ;
    }

    @PutMapping("tipodocumentos")
    public ResponseEntity<TipoDocumentoDTO> actualizarTipoDocumento(@RequestBody TipoDocumentoUpdateDTO tipoDocumentoUpdateDTO){
        return new ResponseEntity<>(tipoDocumentoService.actualizarTipoDocumento(tipoDocumentoUpdateDTO),HttpStatus.OK);
    }

    @DeleteMapping("/tipodocumentos/{tipodocumentoId}")
    public ResponseEntity<TipoDocumentoDTO> eliminarTipoDocumento(@PathVariable("tipodocumentoId") long tipodocumentoId) {
        return new ResponseEntity<>( tipoDocumentoService.eliminarTipoDocumento(tipodocumentoId),HttpStatus.OK);
    }

}
