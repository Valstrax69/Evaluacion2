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

import com.proyecto_eGoal.cl.eGoal.modelo.Comunidad;
import com.proyecto_eGoal.cl.eGoal.service.ComunidadService;



@RestController
@RequestMapping("/api/v2/comunidades")


public class ComunidadController {

    @Autowired
    private ComunidadService comunidadService;

    @GetMapping
    public ResponseEntity<List<Comunidad>> listar(){
        List<Comunidad> comunidades = comunidadService.findByAll();
        if(comunidades.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(comunidades);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Comunidad> buscar(@PathVariable Long id){
        try{
            Comunidad comunidad=comunidadService.findById(id);
            return ResponseEntity.ok(comunidad);

        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Comunidad> guardar(@RequestBody Comunidad comunidad){
        Comunidad comunidadNuevo = comunidadService.save(comunidad);
        return ResponseEntity.status(HttpStatus.CREATED).body(comunidadNuevo);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Comunidad> patchNoticia(@PathVariable Long id , @RequestBody Comunidad parcialComunidad){
        try {
            Comunidad updateComunidad = comunidadService.patchComunidad(id, parcialComunidad);
            return ResponseEntity.ok(updateComunidad);
            
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comunidad> actualizar(@PathVariable Long id, @RequestBody Comunidad comunidad){
        try{
            comunidadService.save(comunidad);
            return ResponseEntity.ok(comunidad);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try {
            comunidadService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


}
