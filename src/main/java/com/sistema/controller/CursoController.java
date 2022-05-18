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
import com.sistema.controller.dto.form.curso.CursoAtualizarForm;
import com.sistema.controller.dto.form.curso.CursoCadastrarForm;
import com.sistema.modelo.Curso;
import com.sistema.repository.CursoRepository;

@RestController
@RequestMapping("/cursos")
public class CursoController {

	@Autowired
	private CursoRepository cursosRepository;
	
	@GetMapping
	public List<CursoDto> listaDeCursos(String nome){
		if(nome == null){
			List<Curso> cursos = cursosRepository.findAll();
			return CursoDto.converter(cursos);
		}
		List<Curso> cursos = cursosRepository.findByNome(nome);
		return CursoDto.converter(cursos);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<CursoDto> cadastrar(@RequestBody  @Valid CursoCadastrarForm form,UriComponentsBuilder uriBuilder){
		Curso curso =  new Curso(form.getNome());
		cursosRepository.save(curso);
		URI uri = uriBuilder.path("/alunos/{id}").buildAndExpand(curso.getId()).toUri();
		return ResponseEntity.created(uri).body(new CursoDto(curso));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<CursoDto> atualizar(@PathVariable Long id, @RequestBody @Valid CursoAtualizarForm form,UriComponentsBuilder uriBuilder){
		Optional<Curso> optional = cursosRepository.findById(id);
		if(optional.isPresent()) {
			Curso curso = form.atualizar(id,cursosRepository);
			return ResponseEntity.ok(new CursoDto(curso));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<CursoDto>  eliminar(@PathVariable Long id){
		Optional<Curso> optional = cursosRepository.findById(id);
		if(optional.isPresent()){
			cursosRepository.deleteById(id);
		}
		return ResponseEntity.notFound().build();

	}
}
