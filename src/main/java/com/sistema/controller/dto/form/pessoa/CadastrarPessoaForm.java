package com.sistema.controller.dto.form.pessoa;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sistema.modelo.TipoDocumento;
import com.sistema.modelo.TipoPessoa;

public class CadastrarPessoaForm {

	@NotNull @NotEmpty @Length(min=3)
	private String nome;
	
	@NotNull @NotEmpty @Length(min=2)
	private String sobrenome;

	private TipoDocumento tipoDocumento;
	
	@NotNull @NotEmpty
	private String documento;
	
	@NotNull @NotEmpty @Length(min=9)
	private String telefone;

	private TipoPessoa tipoPessoa;
	
	public String getNome() {
		return nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}
	public String getDocumento() {
		return documento;
	}
	public String getTelefone() {
		return telefone;
	}
	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}
	
	
}
