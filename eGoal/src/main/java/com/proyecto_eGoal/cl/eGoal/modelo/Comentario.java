package com.proyecto_eGoal.cl.eGoal.modelo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
@Data
@Table (name="comentario")
@NoArgsConstructor
@AllArgsConstructor
@Entity


public class Comentario {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 150 ,nullable = false)
    private String comentario;

    @Column(nullable=false)
    private Date fechaComentario;

    @ManyToOne
    @JoinColumn(name="usuario_id",nullable=false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="publicacion_id",nullable=false)
    private PublicacionComunidad publicacionComunidad;




    

}
