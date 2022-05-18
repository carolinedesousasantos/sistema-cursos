package com.sistema.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Pessoa {
	
	@Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String sobrenome;
	
	@Column(name = "tipo_documento")
	private TipoDocumento tipoDocumento;
	
	private String documento;
	private String telefone;

	@Column(name = "tipo_pessoa")
	private TipoPessoa tipoPessoa;

	public Pessoa() {
		super();
	}
	
	
	public Pessoa(String nome, String sobrenome, TipoDocumento tipoDocumento, String documento, String telefone,
			TipoPessoa tipoPessoa) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.tipoDocumento = tipoDocumento;
		this.documento = documento;
		this.telefone = telefone;
		this.tipoPessoa = tipoPessoa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa statusPessoa) {
		this.tipoPessoa = statusPessoa;
	}
	
}