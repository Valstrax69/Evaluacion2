package com.proyecto_eGoal.cl.eGoal.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.proyecto_eGoal.cl.eGoal.modelo.Noticia;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia,Long> {

    List<Noticia> findById (Integer id);

    List<Noticia> findByTitulo (String titulo);

    List<Noticia> findByEncabezado(String encabezado);

    @Query(""" 
        SELECT  n.titulo,
                n.usuario.nombreUsuario ,
                n.fechaPublicacion
                
        FROM Noticia n 
        
        """)
    List<Object[]> findNoticiaInfo();

    

}
