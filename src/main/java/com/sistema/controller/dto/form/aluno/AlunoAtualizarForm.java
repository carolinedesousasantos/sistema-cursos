package com.sistema.controller.dto.form.aluno;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.sistema.modelo.Aluno;
import com.sistema.repository.AlunoRepository;

public class AlunoAtualizarForm {
	
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

	public Aluno atualizar(Long id, AlunoRepository alunosRepository) {	
		Aluno aluno = alunosRepository.getById(id);
		aluno.setNome(this.nome);
		aluno.setSobrenome(this.sobrenome);
		return aluno;
	}

}
