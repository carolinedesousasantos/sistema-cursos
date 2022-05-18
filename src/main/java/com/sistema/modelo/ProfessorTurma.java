package com.sistema.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "professor_turma")
public class ProfessorTurma {

	@Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;

	@OneToOne  @JoinColumn(name = "professor_id")
	private Pessoa pessoaId;


	@OneToOne  @JoinColumn(name = "turma_id")
	private Turma turmaId;

	public ProfessorTurma() {
		super();
	}

	public ProfessorTurma(Pessoa pessoaId, Turma turmaId) {
		super();
		this.pessoaId = pessoaId;
		this.turmaId = turmaId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Pessoa pessoaId) {
		this.pessoaId = pessoaId;
	}

	public Turma getTurmaId() {
		return turmaId;
	}

	public void setTurmaId(Turma turmaId) {
		this.turmaId = turmaId;
	}
	
	
}
