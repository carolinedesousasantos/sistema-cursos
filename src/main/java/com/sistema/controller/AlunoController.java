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

import com.sistema.controller.dto.AlunoDto;
import com.sistema.controller.dto.form.aluno.AlunoAtualizarForm;
import com.sistema.controller.dto.form.aluno.AlunoCadastrarForm;
import com.sistema.modelo.Aluno;
import com.sistema.repository.AlunoRepository;


@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoRepository alunosRepository;
	
	@GetMapping
	public List<AlunoDto> listaDeAlunos(String nomeAluno){
		if(nomeAluno == null) {
			List<Aluno> alunos = alunosRepository.findAll();
			return AlunoDto.converter(alunos);
		}
		List<Aluno> alunos = alunosRepository.findByNome(nomeAluno);
		return AlunoDto.converter(alunos);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<AlunoDto> cadastrar(@RequestBody @Valid AlunoCadastrarForm form, UriComponentsBuilder uriBuilder) {
		Aluno aluno = new Aluno(form.getNome(), form.getSobrenome());
		alunosRepository.save(aluno);
		URI uri = uriBuilder.path("/alunos/{id}").buildAndExpand(aluno.getId()).toUri();
		return ResponseEntity.created(uri).body(new AlunoDto(aluno));
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<AlunoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AlunoAtualizarForm form, UriComponentsBuilder uriBuilder) {
		Optional<Aluno> optional = alunosRepository.findById(id);
		if(optional.isPresent()) {
			Aluno aluno = form.atualizar(id,alunosRepository);
			return ResponseEntity.ok(new AlunoDto(aluno));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		Optional<Aluno> optional = alunosRepository.findById(id);
		if(optional.isPresent()) {
			alunosRepository.deleteById(id);
		}
		return ResponseEntity.notFound().build();
	}
}
