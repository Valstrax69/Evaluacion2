package com.proyecto_eGoal.cl.eGoal.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyecto_eGoal.cl.eGoal.modelo.Comunidad;


@Repository
public interface ComunidadRepository extends JpaRepository<Comunidad, Long> {

    List<Comunidad> findById (Integer id);

    List<Comunidad> findByNombreComunidad (String nombreComunidad);
    

}
