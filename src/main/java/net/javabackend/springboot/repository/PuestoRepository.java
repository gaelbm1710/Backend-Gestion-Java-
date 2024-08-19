package net.javabackend.springboot.repository;

import net.javabackend.springboot.entity.Puesto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PuestoRepository extends JpaRepository<Puesto, Long> {
}
