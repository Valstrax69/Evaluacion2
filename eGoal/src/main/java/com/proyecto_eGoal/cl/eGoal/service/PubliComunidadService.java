package com.proyecto_eGoal.cl.eGoal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto_eGoal.cl.eGoal.modelo.PublicacionComunidad;
import com.proyecto_eGoal.cl.eGoal.repository.PubliComunidadRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class PubliComunidadService {

    @Autowired
    private PubliComunidadRepository publiComunidadRepository;

    
    public List<PublicacionComunidad> findAll(){
        return publiComunidadRepository.findAll();
    }

    
    public PublicacionComunidad findById(long id){
        return publiComunidadRepository.getById(id);
    }


    public PublicacionComunidad save(PublicacionComunidad publicacionComunidad){
        return publiComunidadRepository.save(publicacionComunidad);
    }

  
    public void delete(long id){
        publiComunidadRepository.deleteById(id);
    }


    public PublicacionComunidad patchPubliComunidad(Long id, PublicacionComunidad parcialPublicacionComunidad){
        Optional<PublicacionComunidad> publicacionComunidadOptional = publiComunidadRepository.findById(id);
        if(publicacionComunidadOptional.isPresent()){

            PublicacionComunidad publicacionComunidadToUpdate = publicacionComunidadOptional.get();

            if(parcialPublicacionComunidad.getTituloPublicacion() != null){
                publicacionComunidadToUpdate.setTituloPublicacion(parcialPublicacionComunidad.getTituloPublicacion());
        
            }
            if(parcialPublicacionComunidad.getPubliComunidad() != null){
                publicacionComunidadToUpdate.setPubliComunidad(parcialPublicacionComunidad.getPubliComunidad());
            }

            return publiComunidadRepository.save(publicacionComunidadToUpdate);

        }else{
            return null;
        }








    }


}
