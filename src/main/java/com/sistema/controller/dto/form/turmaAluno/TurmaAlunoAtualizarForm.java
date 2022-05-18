package com.sistema.controller.dto.form.turmaAluno;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sistema.controller.dto.TurmaAlunoDto;
import com.sistema.modelo.Pessoa;
import com.sistema.modelo.StatusMatriculaAluno;
import com.sistema.modelo.Turma;
import com.sistema.modelo.TurmaAluno;
import com.sistema.repository.PessoaRepository;
import com.sistema.repository.TurmaAlunoRepository;
import com.sistema.repository.TurmaRepository;

public class TurmaAlunoAtualizarForm {

	@NotNull
	@JsonProperty("turma_id")
	private Long idTurma;

	@NotNull
	@JsonProperty("pessoa_id")
	private Long idPessoa;

	@NotNull
	@JsonProperty("status_matricula")
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

	public ResponseEntity<?> atualizar(TurmaAluno turmaAluno, TurmaAlunoRepository turmaAlunoRepository,
			TurmaRepository turmaRepository, PessoaRepository pessoaRepository) {

		Optional<Turma> turma = turmaRepository.findById(this.getIdTurma());
		Optional<Pessoa> pessoa = pessoaRepository.findById(this.getIdPessoa());

		try {
			if (turma.isPresent()) {
				turmaAluno.setIdTurma(turma.get());
			}
			if (pessoa.isPresent() && pessoa.get().getTipoPessoa().toString()== "ALUNO") {
				turmaAluno.setIdPessoa(pessoa.get());
			}else {
				return ResponseEntity.unprocessableEntity().body("TipoPessoa = "+ pessoa.get().getTipoPessoa().toString() +" nao permitido.");
			}
			if(this.getStatusMatricula() !=  null) {
				turmaAluno.setStatusMatricula(this.getStatusMatricula());
			}
			return ResponseEntity.ok(new TurmaAlunoDto(turmaAluno));

		} catch (Exception ex) {
			return ResponseEntity.unprocessableEntity().body(ex);
		}
	}

}
