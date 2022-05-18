package com.sistema.controller.dto.form.curso;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.sistema.modelo.Curso;
import com.sistema.repository.CursoRepository;

public class CursoAtualizarForm {
	@NotNull @NotEmpty @Length(min=6)
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Curso atualizar(Long id, CursoRepository cursosRepository) {
		Curso curso = cursosRepository.getById(id);
		curso.setNome(this.nome);
		return curso;
	}
	
}
