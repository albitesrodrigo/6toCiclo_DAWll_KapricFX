package com.proyectosistemaventas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_producto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto")
    private Long idProducto;

    @Column(length = 100,nullable = false)
    private String nomProducto;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private BigDecimal precio;

    @ManyToOne
    @JoinColumn(name="idCategoria")
    private Categoria categoria;

}
