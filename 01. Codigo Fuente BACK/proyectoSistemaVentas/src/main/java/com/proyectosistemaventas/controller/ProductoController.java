package com.proyectosistemaventas.controller;

import com.proyectosistemaventas.dtos.ProductoCreateDTO;
import com.proyectosistemaventas.dtos.ProductoDTO;
import com.proyectosistemaventas.dtos.ProductoUpdateDTO;
import com.proyectosistemaventas.service.PorductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ProductoController {

    @Autowired
    private PorductoService porductoService;

    @GetMapping("productos")
    public ResponseEntity<List<ProductoDTO>> listarProductos(){
        return   new ResponseEntity<>(porductoService.listarProducto(),
                HttpStatus.OK);
    }

    @GetMapping("/productos/{productoId}")
    public ResponseEntity<ProductoDTO> obtenerProductoPorId
            (@PathVariable("productoId") long productoId){
        return  new ResponseEntity<> ( porductoService.obtenerProductoPorId(productoId),HttpStatus.OK);
    }

    @PostMapping("productos")
    public ResponseEntity<ProductoDTO> registrarProducto
            (@RequestBody ProductoCreateDTO productoCreateDTO){
        return  new ResponseEntity <>( porductoService.resgistrarProducto(productoCreateDTO) ,HttpStatus.OK) ;
    }

    @PutMapping("productos")
    public ResponseEntity<ProductoDTO> actualizarProducto(@RequestBody ProductoUpdateDTO productoUpdateDTO){
        return new ResponseEntity<>(porductoService.actualizarProducto(productoUpdateDTO),HttpStatus.OK);
    }

    @DeleteMapping("/productos/{productoId}")
    public ResponseEntity<ProductoDTO> eliminarProducto
            (@PathVariable("productoId") long productoId) {
        return new ResponseEntity<>( porductoService.eliminarProducto
                (productoId),HttpStatus.OK);
    }
}
