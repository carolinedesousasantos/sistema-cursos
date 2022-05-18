package com.sistema.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.sistema.controller.dto.CursoDto;
import com.sistema.controller.dto.TurmaDto;
import com.sistema.controller.dto.form.curso.CursoAtualizarForm;
import com.sistema.controller.dto.form.turma.TurmaAtualizarForm;
import com.sistema.controller.dto.form.turma.TurmaCadastrarForm;
import com.sistema.modelo.Curso;
import com.sistema.modelo.Turma;
import com.sistema.repository.CursoRepository;
import com.sistema.repository.TurmaRepository;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

	@Autowired
	private TurmaRepository turmaRepository;

	@Autowired
	private CursoRepository cursoRepository;

	@GetMapping
	public List<TurmaDto> listar(String nome) {
		if (nome == null) {
			List<Turma> turmas = turmaRepository.findAll();
			return TurmaDto.converter(turmas);
		}
		List<Turma> turmas = turmaRepository.findByNome(nome);
		return TurmaDto.converter(turmas);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<TurmaDto> cadastrar(@RequestBody @Valid TurmaCadastrarForm form,
			UriComponentsBuilder uriBuilder) {
		Optional<Curso> optional = cursoRepository.findById(form.getCursoId());
		if (optional.isPresent()) {
			Turma turma = new Turma(form.getNome(), form.getHorario(), optional.get());
			turmaRepository.save(turma);
			URI uri = uriBuilder.path("/turmas/{id}").buildAndExpand(turma.getId()).toUri();
			return ResponseEntity.created(uri).body(new TurmaDto(turma));
		} else {
			System.out.println("erro");
			return null;
		}
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TurmaDto> atualizar(@PathVariable Long id, @RequestBody @Valid TurmaAtualizarForm form) {
		Optional<Turma> optionalTurma = turmaRepository.findById(id);
		if (optionalTurma.isPresent()) {
		
			return form.atualizar(id, turmaRepository, cursoRepository);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<TurmaDto> eliminar(@PathVariable Long id) {
		Optional<Turma> optional = turmaRepository.findById(id);
		if (optional.isPresent()) {
			turmaRepository.deleteById(id);
		}
		return ResponseEntity.notFound().build();
	}
}
