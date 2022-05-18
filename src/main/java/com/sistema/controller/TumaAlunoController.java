package com.sistema.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sistema.controller.dto.TurmaAlunoDto;
import com.sistema.controller.dto.TurmaDto;
import com.sistema.controller.dto.form.turma.TurmaAtualizarForm;
import com.sistema.controller.dto.form.turma.TurmaCadastrarForm;
import com.sistema.controller.dto.form.turmaAluno.TurmaAlunoAtualizarForm;
import com.sistema.controller.dto.form.turmaAluno.TurmaAlunoCadastrarForm;
import com.sistema.modelo.Curso;
import com.sistema.modelo.Pessoa;
import com.sistema.modelo.StatusMatriculaAluno;
import com.sistema.modelo.Turma;
import com.sistema.modelo.TurmaAluno;
import com.sistema.repository.PessoaRepository;
import com.sistema.repository.TurmaAlunoRepository;
import com.sistema.repository.TurmaRepository;

@RestController
@RequestMapping("/turma-alunos")
public class TumaAlunoController {

	@Autowired
	TurmaAlunoRepository turmaAlunoRepository;

	@Autowired
	TurmaRepository turmaRepository;

	@Autowired
	PessoaRepository pessoaRepository;

	@GetMapping
	public List<TurmaAlunoDto> listar(Long status) {
		if (status == null) {
			List<TurmaAluno> turmas = turmaAlunoRepository.findAll();
			return TurmaAlunoDto.converter(turmas);
		}
		List<TurmaAluno> turmas = turmaAlunoRepository.findByStatusMatricula(status);
		return TurmaAlunoDto.converter(turmas);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid TurmaAlunoCadastrarForm form,
			UriComponentsBuilder uriBuilder) {
		Optional<Turma> turma = turmaRepository.findById(form.getIdTurma());
		Optional<Pessoa> pessoa = pessoaRepository.findById(form.getIdPessoa());

		if (turma.isPresent() && pessoa.isPresent()) {
			if (pessoa.get().getTipoPessoa().toString() == "ALUNO") {
				TurmaAluno turmaAluno = new TurmaAluno(turma.get(), pessoa.get(), StatusMatriculaAluno.MATRICULADO);
				turmaAlunoRepository.save(turmaAluno);
				URI uri = uriBuilder.path("/turmas-alunos/{id}").buildAndExpand(turmaAluno.getId()).toUri();
				return ResponseEntity.created(uri).body(new TurmaAlunoDto(turmaAluno));
			} else {
				return ResponseEntity.unprocessableEntity()
						.body("Pessoa tipo: " + pessoa.get().getTipoPessoa().toString() + " nao permitido");
			}
		} else {
			return ResponseEntity.unprocessableEntity().body("Entidade nao existe");
		}
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody @Valid TurmaAlunoAtualizarForm form) {
		Optional<TurmaAluno> turmaAluno = turmaAlunoRepository.findById(id);
		if (turmaAluno.isPresent()) {
			return form.atualizar(turmaAluno.get(), turmaAlunoRepository, turmaRepository, pessoaRepository);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<TurmaAlunoDto> eliminar(@PathVariable Long id) {
		Optional<TurmaAluno> optional = turmaAlunoRepository.findById(id);
		if (optional.isPresent()) {
			turmaAlunoRepository.deleteById(id);
		}
		return ResponseEntity.notFound().build();
	}
}
