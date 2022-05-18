package com.sistema.controller.dto.form.turma;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sistema.controller.dto.TurmaDto;
import com.sistema.modelo.Curso;
import com.sistema.modelo.Horario;
import com.sistema.modelo.Turma;
import com.sistema.repository.CursoRepository;
import com.sistema.repository.TurmaRepository;

public class TurmaAtualizarForm {

	@NotNull @NotEmpty @Length(min=3)
	private String nome;

	private Horario horario;
	
	@JsonProperty("curso_id") @NotNull 
	private Long cursoId;

	public String getNome() {
		return nome;
	}

	public Horario getHorario() {
		return horario;
	}

	public Long getcursoIdid() {
		return cursoId;
	}
	
	public ResponseEntity<TurmaDto>  atualizar(Long id, TurmaRepository turmaRepository, CursoRepository cursoRepository) {
		Turma turma = turmaRepository.getById(id);
		Optional<Curso> curso = cursoRepository.findById(this.getcursoIdid());
		if(curso.isPresent()){
			turma.setNome(this.nome);
			turma.setHorario(this.horario);
			turma.setCursoId(curso.get());
			return ResponseEntity.ok(new TurmaDto(turma));
		}else {
			System.out.println("Curso nao existe");
			return  ResponseEntity.notFound().build();
		}
	}
}
