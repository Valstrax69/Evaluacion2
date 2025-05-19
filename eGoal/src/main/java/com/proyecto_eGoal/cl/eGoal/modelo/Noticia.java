package com.proyecto_eGoal.cl.eGoal.modelo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table (name="noticia")
@NoArgsConstructor
@AllArgsConstructor
@Entity



public class Noticia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false)
    private String titulo; 

    @Column(nullable=false)
    private String encabezado;

    @Column(length = 500,nullable = false)
    private String cuerpoNoticia;

    @Column(nullable=false)
    private Date fechaPublicacion;

    @ManyToOne
    @JoinColumn(name="usuario_id",nullable =false)
    private Usuario usuario;


}
