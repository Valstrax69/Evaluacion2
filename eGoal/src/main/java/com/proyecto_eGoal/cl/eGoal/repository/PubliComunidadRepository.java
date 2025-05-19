package com.proyecto_eGoal.cl.eGoal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.proyecto_eGoal.cl.eGoal.modelo.PublicacionComunidad;


@Repository
public interface PubliComunidadRepository extends JpaRepository <PublicacionComunidad, Long> {

    List<PublicacionComunidad> findById (Integer id);

    List<PublicacionComunidad> findByTituloPublicacion(String tituloPublicacion);

}
