package com.proyecto_eGoal.cl.eGoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.proyecto_eGoal.cl.eGoal.modelo.TipoUsuario;



public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario,Long> {

    List<TipoUsuario> findById (Integer id);
    List<TipoUsuario> findByTipoUsuario(String tipoUsuario);


}
