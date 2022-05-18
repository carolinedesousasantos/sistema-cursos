package com.sistema.controller.dto.form.turmaAluno;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sistema.modelo.Pessoa;
import com.sistema.modelo.StatusMatriculaAluno;
import com.sistema.modelo.Turma;

public class TurmaAlunoCadastrarForm {

	@NotNull @JsonProperty("turma_id")
	private Long idTurma;
	
	@NotNull 	@JsonProperty("pessoa_id")
	private Long idPessoa;
	
	@NotNull @JsonProperty("status_matricula") 
	private StatusMatriculaAluno statusMatricula;

	public Long getIdTurma() {
		return idTurma;
	}

	public Long getIdPessoa() {
		return idPessoa;
	}

	public StatusMatriculaAluno getStatusMatricula() {
		return statusMatricula;
	}
	
	
	
}
