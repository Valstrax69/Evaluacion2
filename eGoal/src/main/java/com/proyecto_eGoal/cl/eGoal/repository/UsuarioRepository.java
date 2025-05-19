package com.proyecto_eGoal.cl.eGoal.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto_eGoal.cl.eGoal.modelo.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findById (Integer id);

    List<Usuario> findBynombreUsuario (String nombreUsuario);

    List<Usuario> findByCorreo (String correo);

}
