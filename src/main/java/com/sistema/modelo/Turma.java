package com.sistema.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Turma {
	
	@Column(name = "id")@Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;

	private String nome;
	
	private Horario horario;
	
	@OneToOne  @JoinColumn(name = "curso_id")
	private Curso cursoId;
	
	public Turma() {
		super();
	}

	public Turma(String nome, Horario horario, Curso cursoId) {
		super();
		this.nome= nome;
		this.horario = horario;
		this.cursoId = cursoId;
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

	public void setCursoId(Curso cursoId) {
		this.cursoId = cursoId;
	}
	
}
