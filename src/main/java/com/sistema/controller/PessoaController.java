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
import com.sistema.controller.dto.PessoaDto;
import com.sistema.controller.dto.form.pessoa.AtualizarPessoaForm;
import com.sistema.controller.dto.form.pessoa.CadastrarPessoaForm;
import com.sistema.modelo.Curso;
import com.sistema.modelo.Pessoa;
import com.sistema.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	PessoaRepository pessoaRepository;
	
	@GetMapping
	public List<PessoaDto> listaPessoas(String nomePessoa) {
		if(nomePessoa == null) {
			List<Pessoa> pessoas = pessoaRepository.findAll();
			return PessoaDto.converter(pessoas);
		}
		List<Pessoa> pessoas = pessoaRepository.findByNome(nomePessoa);
			return PessoaDto.converter(pessoas);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<PessoaDto> cadastrar(@RequestBody @Valid CadastrarPessoaForm form, UriComponentsBuilder uriBuilder){
			Pessoa pessoa = new Pessoa(
					form.getNome(), form.getSobrenome(), 
					form.getTipoDocumento(),form.getDocumento(), 
					form.getTelefone(), form.getTipoPessoa());
			pessoaRepository.save(pessoa);
			URI uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(pessoa.getId()).toUri();
			return ResponseEntity.created(uri).body(new PessoaDto(pessoa));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PessoaDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarPessoaForm form,UriComponentsBuilder uriBuilder){
		Optional<Pessoa> optional = pessoaRepository.findById(id);
		if(optional.isPresent()) {
			Pessoa pessoa = form.atualizar(id,pessoaRepository);
			return ResponseEntity.ok(new PessoaDto(pessoa));
		}
		return ResponseEntity.notFound().build();
	}
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<PessoaDto>  eliminar(@PathVariable Long id){
		Optional<Pessoa> optional = pessoaRepository.findById(id);
		if(optional.isPresent()){
			pessoaRepository.deleteById(id);
		}
		return ResponseEntity.notFound().build();

	}
}
