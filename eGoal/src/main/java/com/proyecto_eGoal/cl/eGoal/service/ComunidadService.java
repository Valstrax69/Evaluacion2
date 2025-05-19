package com.proyecto_eGoal.cl.eGoal.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto_eGoal.cl.eGoal.modelo.Comunidad;
import com.proyecto_eGoal.cl.eGoal.repository.ComunidadRepository;
import jakarta.transaction.Transactional;
 
@Service
@Transactional
public class ComunidadService {

    @Autowired
    private ComunidadRepository comunidadRepository;

    public List<Comunidad> findByAll(){
        return comunidadRepository.findAll();
    }

    public Comunidad findById(Long id){
        return comunidadRepository.getById(id);
    }

    public Comunidad save(Comunidad comunidad){
        return comunidadRepository.save(comunidad);
    }
    public void delete(Long id){
        comunidadRepository.deleteById(id);
    }
    public Comunidad patchComunidad(Long Id, Comunidad parcialComunidad){
        Optional<Comunidad> comunidadOptional = comunidadRepository.findById(Id);
        if(comunidadOptional.isPresent()){

            Comunidad comunidadToUpdate = comunidadOptional.get();

            if(parcialComunidad.getNombreComunidad() != null){
                comunidadToUpdate.setNombreComunidad(parcialComunidad.getNombreComunidad());
            }
            if(parcialComunidad.getDescripcion() != null){
                comunidadToUpdate.setDescripcion(parcialComunidad.getDescripcion());
            }
            return comunidadRepository.save(comunidadToUpdate);
        }else {
            return null;
        }
    }
    



}
