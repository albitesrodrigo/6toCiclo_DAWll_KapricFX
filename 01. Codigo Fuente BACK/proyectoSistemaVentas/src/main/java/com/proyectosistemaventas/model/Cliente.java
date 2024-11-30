package com.proyectosistemaventas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tb_cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCliente")
    private Long idCliente;

    @Column(length = 100,nullable = false)
    private String nombre;

    @Column(length = 100,nullable = false)
    private String apePaterno;

    @Column(length = 100,nullable = false)
    private String apeMaterno;

    @Column(length = 10,nullable = false)
    private String numDocumento;

    @Column(length = 100,nullable = false)
    private String direccion;

    @Column(length = 100,nullable = false)
    private String correo;

    @ManyToOne
    @JoinColumn(name="idTipo")
    private TipoDocumento tipoDocumento;

}
