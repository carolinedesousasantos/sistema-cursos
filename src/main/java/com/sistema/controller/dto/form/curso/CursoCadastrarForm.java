package com.sistema.controller.dto.form.curso;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class CursoCadastrarForm {
	
	@NotNull @NotEmpty @Length(min=3)
	private String nome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
		
	
	

}
