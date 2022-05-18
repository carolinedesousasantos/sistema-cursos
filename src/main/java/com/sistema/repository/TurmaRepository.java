package com.sistema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.modelo.Turma;


public interface TurmaRepository extends JpaRepository<Turma, Long>{
	List<Turma> findByNome(String nome);
}
