package com.sistema.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.sistema.modelo.Aluno;
import com.sistema.modelo.Curso;

public class AlunoDto {
	
	private Long id;
	private String nome;
	private String sobrenome;

	public AlunoDto(Aluno aluno) {
		this.id = aluno.getId();
		this.nome = aluno.getNome();
		this.sobrenome = aluno.getSobrenome();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public static List<AlunoDto> converter(List<Aluno> alunos) {
		return alunos.stream().map(AlunoDto::new).collect(Collectors.toList());
	}
	
	
	
}
