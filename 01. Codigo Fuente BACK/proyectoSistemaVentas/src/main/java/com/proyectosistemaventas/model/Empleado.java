package com.proyectosistemaventas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_empleado")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmpleado")
    private Long idEmpleado;

    @Column(name = "nombre",length = 100,nullable = false)
    private String nombre;

    @Column(name = "apePaterno",length = 100,nullable = false)
    private String apePaterno;

    @Column(name = "apeMaterno",length = 100,nullable = false)
    private String apeMaterno;

    @Column(length = 10,nullable = false)
    private String numDocumento;

    @Column(length = 100,nullable = false)
    private String direccion;

    @Column(length = 100,nullable = false)
    private String correo;

    @Column(name = "telefono",length = 9,nullable = false)
    private Integer telefono;

    @Column(nullable = false)
    @Temporal(value= TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaNacimiento;

    @ManyToOne
    @JoinColumn(name="idTipo")
    private TipoDocumento tipoDocumento;

    @ManyToOne
    @JoinColumn(name="idEstado")
    private Estado estado;

}

