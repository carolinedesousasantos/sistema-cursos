package com.sistema.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sistema.modelo.Curso;
import com.sistema.modelo.Horario;
import com.sistema.modelo.ProfessorTurma;
import com.sistema.modelo.Turma;
import com.sistema.modelo.TurmaAluno;

public class TurmaDto {

	private Long id;
	private String nome;
	private Horario horario;

	@JsonProperty("curso_id")
	private Curso cursoId;

	public TurmaDto(Turma turma) {
		super();
		this.id = turma.getId();
		this.nome = turma.getNome();
		this.horario = turma.getHorario();
		this.cursoId = turma.getCursoId();
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

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public Curso getCursoId() {
		return cursoId;
	}

	public void setCurso_id(Curso cursoId) {
		this.cursoId = cursoId;
	}

	public static List<TurmaDto> converter(List<Turma> turmas) {
		return turmas.stream().map(TurmaDto::new).collect(Collectors.toList());
	}
}
