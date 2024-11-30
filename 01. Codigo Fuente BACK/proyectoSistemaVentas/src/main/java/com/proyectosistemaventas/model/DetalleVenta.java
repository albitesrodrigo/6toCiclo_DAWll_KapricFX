package com.proyectosistemaventas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_detalleVenta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetalleVenta")
    private Long idDetalleVenta;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(nullable = false)
    private BigDecimal preVenta;

    @Column(nullable = false)
    private BigDecimal importe;

    @ManyToOne
    @JoinColumn(name = "idVenta", nullable = false)
    private Ventas venta;

    @ManyToOne
    @JoinColumn(name = "idProducto",nullable = false)
    private Producto producto;

}
