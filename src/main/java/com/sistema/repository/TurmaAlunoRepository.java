package com.sistema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.modelo.TurmaAluno;

public interface TurmaAlunoRepository extends JpaRepository<TurmaAluno, Long> {

	List<TurmaAluno> findByStatusMatricula(Long status);

}
