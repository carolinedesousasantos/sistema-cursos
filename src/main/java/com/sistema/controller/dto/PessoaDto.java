package com.sistema.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.sistema.modelo.Pessoa;
import com.sistema.modelo.TipoDocumento;
import com.sistema.modelo.TipoPessoa;

public class PessoaDto {

	private Long id;
	private String nome;
	private String sobrenome;
	private TipoDocumento tipoDocumento;
	private String documento;
	private String telefone;
	private TipoPessoa statusPessoa;
	
	public PessoaDto(Pessoa pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.sobrenome = pessoa.getSobrenome();
		this.tipoDocumento = pessoa.getTipoDocumento();
		this.documento = pessoa.getDocumento();
		this.telefone = pessoa.getTelefone();
		this.statusPessoa = pessoa.getTipoPessoa();
	}
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public TipoDocumento getTipoDeDocumento() {
		return tipoDocumento;
	}
	public String getDocumento() {
		return documento;
	}
	public String getTelefone() {
		return telefone;
	}
	public TipoPessoa getTipoPessoa() {
		return statusPessoa;
	}
	public static List<PessoaDto> converter(List<Pessoa> pessoas) {
		return pessoas.stream().map(PessoaDto::new).collect(Collectors.toList());
	}


}
