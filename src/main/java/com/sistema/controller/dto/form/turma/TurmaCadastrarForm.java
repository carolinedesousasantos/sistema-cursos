package com.sistema.controller.dto.form.turma;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sistema.modelo.Curso;
import com.sistema.modelo.Horario;

public class TurmaCadastrarForm {
	@NotNull @NotEmpty @Length(min=3)
	private String nome;

	private Horario horario;
	
	@JsonProperty("curso_id") @NotNull 
	private Long cursoId;

	public String getNome() {
		return nome;
	}

	public Horario getHorario() {
		return horario;
	}

	public Long getCursoId() {
		return cursoId;
	}

}
