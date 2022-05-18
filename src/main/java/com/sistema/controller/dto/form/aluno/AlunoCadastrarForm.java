package com.sistema.controller.dto.form.aluno;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;


public class AlunoCadastrarForm {

	@NotNull @NotEmpty @Length(min=6)
	private String nome;
	
	@NotNull @NotEmpty @Length(min=6)
	private String sobrenome;
	
	
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

}
