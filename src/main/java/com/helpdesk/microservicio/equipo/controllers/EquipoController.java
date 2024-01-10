package com.helpdesk.microservicio.equipo.controllers;

import com.helpdesk.microservicio.equipo.models.Equipo;
import com.helpdesk.microservicio.equipo.services.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public class EquipoController {
    @RestController
    @RequestMapping
    public class UsuarioController {
        @Autowired
        private EquipoService equipoService;

        @GetMapping
        public ResponseEntity<?> obtUsuarios(){
            return ResponseEntity.ok().body(equipoService.findAll());
        }
        @GetMapping("/{id}")
        public ResponseEntity<?> obtUsuario(@PathVariable Long id){
            Optional<Equipo> o = equipoService.findById(id);
            if (o.isEmpty()){
                return  ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(o.get());
        }
        @PostMapping
        public ResponseEntity<?> crear(@RequestBody Equipo equipo){
            return ResponseEntity.status(HttpStatus.CREATED).body(equipoService.save(equipo));

        }
        @PutMapping("/{id}")
        public ResponseEntity<?> actualizar(@RequestBody Equipo equipo, @PathVariable Long id){
            Optional<Equipo> equipoMod= equipoService.findById(id);
            if (equipoMod.isEmpty()){
                return ResponseEntity.notFound().build();
            }
            Equipo equipoDB = equipoMod.get();
            equipoDB.setSerieActivoFijo(equipo.getSerieActivoFijo());
            equipoDB.setMarca(equipo.getMarca());
            equipoDB.setTipoEquipo(equipo.getTipoEquipo());
            equipoDB.setObservaciones(equipo.getObservaciones());

            return ResponseEntity.status(HttpStatus.CREATED).body(equipoService.save(equipoDB));

        }
        @DeleteMapping("/{id}")
        public ResponseEntity<?> eliminar(@PathVariable Long id){
            equipoService.deleteById(id);
            return ResponseEntity.noContent().build();

        }
    }
}
