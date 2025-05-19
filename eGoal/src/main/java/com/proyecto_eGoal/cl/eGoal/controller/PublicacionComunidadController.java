package com.proyecto_eGoal.cl.eGoal.controller;

import java.util.List;

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

import com.proyecto_eGoal.cl.eGoal.modelo.PublicacionComunidad;
import com.proyecto_eGoal.cl.eGoal.service.PubliComunidadService;


@RestController
@RequestMapping("/api/v2/publicacionescomunidades")
public class PublicacionComunidadController {

    @Autowired
    private PubliComunidadService publiComunidadService;

    @GetMapping
    public ResponseEntity<List<PublicacionComunidad>> listar(){
        List<PublicacionComunidad> publicacionesComunidad = publiComunidadService.findAll();
        if(publicacionesComunidad.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(publicacionesComunidad);
    }


    @GetMapping("/{id}")
    public ResponseEntity<PublicacionComunidad> buscar(@PathVariable Long id){
        try{
            PublicacionComunidad publicacionComunidad=publiComunidadService.findById(id);
            return ResponseEntity.ok(publicacionComunidad);

        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<PublicacionComunidad> guardar(@RequestBody PublicacionComunidad publicacionComunidad){
        PublicacionComunidad publicacionComunidadNuevo = publiComunidadService.save(publicacionComunidad);
        return ResponseEntity.status(HttpStatus.CREATED).body(publicacionComunidadNuevo);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PublicacionComunidad> patchPubliComunidad(@PathVariable Long id , @RequestBody PublicacionComunidad parcialPublicacionComunidad){
        try {
            PublicacionComunidad updatePublicacionComunidad = publiComunidadService.patchPubliComunidad(id, parcialPublicacionComunidad);
            return ResponseEntity.ok(updatePublicacionComunidad);
            
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublicacionComunidad> actualizar(@PathVariable Long id, @RequestBody PublicacionComunidad publicacionComunidad){
        try{
            publiComunidadService.save(publicacionComunidad);
            return ResponseEntity.ok(publicacionComunidad);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try {
            publiComunidadService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


}
