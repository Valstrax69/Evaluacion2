package com.proyecto_eGoal.cl.eGoal.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto_eGoal.cl.eGoal.modelo.Noticia;
import com.proyecto_eGoal.cl.eGoal.service.NoticiaService;


@RestController
@RequestMapping("/api/v2/noticias")
public class NoticiaController {

    @Autowired
    private NoticiaService noticiaService;

    @GetMapping
    public ResponseEntity<List<Noticia>> listar(){
        List<Noticia> noticias = noticiaService.findAll();
        if(noticias.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(noticias);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Noticia> buscar(@PathVariable Long id){
        try{
            Noticia noticia=noticiaService.findById(id);
            return ResponseEntity.ok(noticia);

        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Noticia> guardar(@RequestBody Noticia noticia){
        Noticia noticiaNuevo = noticiaService.save(noticia);
        return ResponseEntity.status(HttpStatus.CREATED).body(noticiaNuevo);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Noticia> patchNoticia(@PathVariable Long id , @RequestBody Noticia parcialNoticia){
        try {
            Noticia updateNoticia = noticiaService.patchNoticia(id, parcialNoticia);
            return ResponseEntity.ok(updateNoticia);
            
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Noticia> actualizar(@PathVariable Long id, @RequestBody Noticia noticia){
        try{
            noticiaService.save(noticia);
            return ResponseEntity.ok(noticia);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try {
            noticiaService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/noticiainfo")
    public ResponseEntity<List<Map<String, Object>>> resumen() {
        List<Map<String, Object>> resumen = noticiaService.obtenerNoticiaInfo();
        if (resumen.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resumen);
    }


}
