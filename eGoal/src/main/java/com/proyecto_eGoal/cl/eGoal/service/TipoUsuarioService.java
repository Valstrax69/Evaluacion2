package com.proyecto_eGoal.cl.eGoal.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto_eGoal.cl.eGoal.modelo.TipoUsuario;
import com.proyecto_eGoal.cl.eGoal.repository.TipoUsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TipoUsuarioService {
     @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    
    public List<TipoUsuario> findAll(){
        return tipoUsuarioRepository.findAll();
    }

    
    public TipoUsuario findById(long id){
        return tipoUsuarioRepository.getById(id);
    }


    public TipoUsuario save(TipoUsuario tipoUsuario){
        return tipoUsuarioRepository.save(tipoUsuario);
    }

  
    public void delete(long id){
        tipoUsuarioRepository.deleteById(id);
    }


    public TipoUsuario patchTipoUsuario(Long id, TipoUsuario parcialTipoUsuario){
        Optional<TipoUsuario> tipoUsuarioOptional = tipoUsuarioRepository.findById(id);
        if(tipoUsuarioOptional.isPresent()){

            TipoUsuario tipoUsuarioToUpdate = tipoUsuarioOptional.get();

            if(parcialTipoUsuario.getTipoUsuario() != null){
                tipoUsuarioToUpdate.setTipoUsuario(parcialTipoUsuario.getTipoUsuario());
        
            }

            return tipoUsuarioRepository.save(tipoUsuarioToUpdate);

        }else{
            return null;
        }








    }

}
