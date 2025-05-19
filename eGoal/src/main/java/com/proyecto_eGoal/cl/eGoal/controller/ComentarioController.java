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
import com.proyecto_eGoal.cl.eGoal.modelo.Comentario;
import com.proyecto_eGoal.cl.eGoal.service.ComentarioService;


@RestController
@RequestMapping("/api/v2/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @GetMapping
    public ResponseEntity<List<Comentario>> listar(){
        List<Comentario> comentarios = comentarioService.findByAll();
        if(comentarios.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(comentarios);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Comentario> buscar(@PathVariable Long id){
        try{
            Comentario comentario=comentarioService.findById(id);
            return ResponseEntity.ok(comentario);

        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/comenusuarios")
    public ResponseEntity<List<Map<String, Object>>> resumen() {
        List<Map<String, Object>> resumen = comentarioService.obtenerComentarioConUsuario();
        if (resumen.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resumen);
    }




    @PostMapping
    public ResponseEntity<Comentario> guardar(@RequestBody Comentario comentario){
        Comentario comentarioNuevo = comentarioService.save(comentario);
        return ResponseEntity.status(HttpStatus.CREATED).body(comentarioNuevo);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Comentario> patchComentario(@PathVariable Long id , @RequestBody Comentario parcialComentario){
        try {
            Comentario updateComentario = comentarioService.patchComentario(id, parcialComentario);
            return ResponseEntity.ok(updateComentario);
            
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comentario> actualizar(@PathVariable Long id, @RequestBody Comentario comentario){
        try{
            comentarioService.save(comentario);
            return ResponseEntity.ok(comentario);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try {
            comentarioService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }




}
