package com.sistema.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sistema.modelo.Pessoa;
import com.sistema.modelo.StatusMatriculaAluno;
import com.sistema.modelo.Turma;
import com.sistema.modelo.TurmaAluno;

public class TurmaAlunoDto {

	private Long id;
	
	@JsonProperty("turma_id")
	private Turma idTurma;
	
	@JsonProperty("pessoa_id")
	private Pessoa idPessoa;
	
	@JsonProperty("status_matricula")
	private StatusMatriculaAluno statusMatricula;
	
	public TurmaAlunoDto(TurmaAluno turmaAluno) {
		super();
		this.id = turmaAluno.getId();
		this.idTurma = turmaAluno.getIdTurma();
		this.idPessoa = turmaAluno.getIdPessoa();
		this.statusMatricula = turmaAluno.getStatusMatricula();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Turma getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Turma idTurma) {
		this.idTurma = idTurma;
	}

	public Pessoa getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Pessoa idPessoa) {
		this.idPessoa = idPessoa;
	}
	
	public StatusMatriculaAluno getStatusMatricula() {
		return statusMatricula;
	}

	public void setStatusMatricula(StatusMatriculaAluno statusMatricula) {
		this.statusMatricula = statusMatricula;
	}

	public static List<TurmaAlunoDto> converter(List<TurmaAluno> turmaAluno) {
		return turmaAluno.stream().map(TurmaAlunoDto::new).collect(Collectors.toList());
	}
}
