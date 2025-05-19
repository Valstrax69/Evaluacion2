package com.proyecto_eGoal.cl.eGoal.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto_eGoal.cl.eGoal.modelo.Usuario;
import com.proyecto_eGoal.cl.eGoal.repository.UsuarioRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Usuario findById (Long id){
        return usuarioRepository.getById(id);
    }

    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public void delete(Long id){
        usuarioRepository.deleteById(id);
    }
    public Usuario patchUsuario(Long id, Usuario parcialUsuario){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {

            Usuario usuarioToUpdate = usuarioOptional.get();

            if (parcialUsuario.getNombreUsuario() != null) {
                usuarioToUpdate.setNombreUsuario(parcialUsuario.getNombreUsuario());
            }

            if(parcialUsuario.getEquipoFavorito() != null){
                usuarioToUpdate.setEquipoFavorito(parcialUsuario.getEquipoFavorito());
            }
            if(parcialUsuario.getNumTelefono() != null){
                usuarioToUpdate.setNumTelefono(parcialUsuario.getNumTelefono());
            }
            if(parcialUsuario.getPassword() != null){
                usuarioToUpdate.setPassword(parcialUsuario.getPassword());
            }

            return usuarioRepository.save(usuarioToUpdate);
        } else {
            return null; // or throw an exception
        }
    }









}
