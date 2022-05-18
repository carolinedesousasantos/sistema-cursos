package com.sistema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.modelo.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	List<Aluno> findByNome(String nomeAluno);
}
