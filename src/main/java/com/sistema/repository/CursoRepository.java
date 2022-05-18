package com.sistema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
	
	List<Curso> findByNome(String nomeCurso);
}
