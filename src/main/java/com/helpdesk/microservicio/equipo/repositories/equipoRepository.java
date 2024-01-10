package com.helpdesk.microservicio.equipo.repositories;

import com.helpdesk.microservicio.equipo.models.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface equipoRepository extends JpaRepository<Equipo, Long> {
}

