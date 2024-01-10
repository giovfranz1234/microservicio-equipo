package com.helpdesk.microservicio.equipo.services;

import com.helpdesk.microservicio.equipo.models.Equipo;

import java.util.List;
import java.util.Optional;

public interface EquipoService {
    public List<Equipo> findAll();

    public Optional<Equipo> findById(Long id);

    public Equipo save(Equipo equipo);
    public void deleteById(Long id);
}
