package com.proyecto_eGoal.cl.eGoal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto_eGoal.cl.eGoal.modelo.Comentario;
import com.proyecto_eGoal.cl.eGoal.repository.ComentarioRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    public List<Comentario> findByAll(){
        return comentarioRepository.findAll();
    }

    public Comentario findById(Long id){
        return comentarioRepository.getById(id);
    }

    public Comentario save(Comentario comentario){
        return comentarioRepository.save(comentario);
    }

    public void delete(long id){
        comentarioRepository.deleteById(id);
    }

    public Comentario patchComentario(Long id, Comentario parcialComentario){
        Optional<Comentario> comentarioOptional = comentarioRepository.findById(id);
        if(comentarioOptional.isPresent()){

            Comentario comentarioToUptade = comentarioOptional.get();

            if(parcialComentario.getComentario() != null){
                comentarioToUptade.setComentario(parcialComentario.getComentario());
            }
            if(parcialComentario.getPublicacionComunidad()!=null){
                comentarioToUptade.setPublicacionComunidad(parcialComentario.getPublicacionComunidad());
            }
            if(parcialComentario.getUsuario()!=null){
                comentarioToUptade.setUsuario(parcialComentario.getUsuario());
            }

            return comentarioRepository.save(comentarioToUptade);
        }else{
            return null;
        }
    }
    public List<Map<String, Object>> obtenerComentarioConUsuario() {
        List<Object[]> resultados = comentarioRepository.findComentarioConUsuario();
        List<Map<String, Object>> lista = new ArrayList<>();

        for (Object[] fila : resultados) {
            Map<String, Object> datos = new HashMap<>();
            datos.put("usuario", fila[0]);
            datos.put("comentario", fila[1]);
            lista.add(datos);
        }

        return lista;
    }
}
