package com.proyecto_eGoal.cl.eGoal.modelo;

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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name="usuario")

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(unique = true,length = 20,nullable = false)
    private String nombreUsuario;

    @Column(nullable=true)
    private String equipoFavorito;

    @Column(nullable = false)
    private String password;

    @Column(unique=true,nullable = false)
    private String correo;

    @Column(nullable = true)
    private String numTelefono;

    @Column(nullable = false)
    private String verificado;

    @ManyToOne
    @JoinColumn(name="tipo_usuario_id",nullable =false)
    private TipoUsuario tipoUsuario;





    


}
