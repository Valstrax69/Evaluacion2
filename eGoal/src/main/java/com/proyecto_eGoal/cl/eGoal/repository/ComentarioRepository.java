package com.proyecto_eGoal.cl.eGoal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.proyecto_eGoal.cl.eGoal.modelo.Comentario;
import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository <Comentario, Long> {


    @Query(""" 
        SELECT  c.usuario.nombreUsuario ,
                c.comentario 
        FROM Comentario c 
        
        """)
    List<Object[]> findComentarioConUsuario();

    List<Comentario> findById (Integer id);

}
