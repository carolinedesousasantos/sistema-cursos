package com.sistema.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class TurmaAluno {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "turma_id")
	private Turma idTurma;

	@OneToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa idPessoa;

	@Column(name = "status_matricula")
	private StatusMatriculaAluno statusMatricula;

	public TurmaAluno() {
		super();
	}

	public TurmaAluno(Turma idTurma, Pessoa idPessoa, StatusMatriculaAluno statusMatricula) {
		super();
		this.idTurma = idTurma;
		this.idPessoa = idPessoa;
		this.statusMatricula = statusMatricula;
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

}
