package com.proyecto_eGoal.cl.eGoal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto_eGoal.cl.eGoal.modelo.Noticia;
import com.proyecto_eGoal.cl.eGoal.repository.NoticiaRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional

public class NoticiaService {

    @Autowired
    private NoticiaRepository noticiaRepository;

    //Listar
    public List<Noticia> findAll(){
        return noticiaRepository.findAll();
    }

    //Busca por ID
    public Noticia findById(long id){
        return noticiaRepository.getById(id);
    }

    //Un guardado
    public Noticia save(Noticia noticia){
        return noticiaRepository.save(noticia);
    }

    //Borra por id 
    public void delete(long id){
        noticiaRepository.deleteById(id);
    }


    public Noticia patchNoticia(Long id, Noticia parcialNoticia){
        Optional<Noticia> noticiaOptional = noticiaRepository.findById(id);
        if(noticiaOptional.isPresent()){

            Noticia noticiaToUpdate = noticiaOptional.get();

            if(parcialNoticia.getTitulo() != null){
                noticiaToUpdate.setTitulo(parcialNoticia.getTitulo());
        
            }
            if(parcialNoticia.getCuerpoNoticia() != null){
                noticiaToUpdate.setCuerpoNoticia(parcialNoticia.getCuerpoNoticia());
            }
            if(parcialNoticia.getEncabezado() != null){
                noticiaToUpdate.setEncabezado(parcialNoticia.getEncabezado());
            }

            return noticiaRepository.save(noticiaToUpdate);

        }else{
            return null;
        }








    }
    public List<Map<String, Object>> obtenerNoticiaInfo() {
        List<Object[]> resultados = noticiaRepository.findNoticiaInfo();
        List<Map<String, Object>> lista = new ArrayList<>();

        for (Object[] fila : resultados) {
            Map<String, Object> datos = new HashMap<>();
            datos.put("titulo_noticia", fila[0]);
            datos.put("usuario", fila[1]);
            datos.put("fecha", fila[2]);
            lista.add(datos);
        }

        return lista;
    }






}
