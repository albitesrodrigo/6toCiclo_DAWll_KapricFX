package com.proyectosistemaventas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="tb_tipodoc")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoDocumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipo")
    private Long idTipo;

    @Column(length = 200, nullable = false)
    private String desTipo;
}
