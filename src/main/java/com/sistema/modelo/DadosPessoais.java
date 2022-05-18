package com.sistema.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dados_pessoais")
public class DadosPessoais {
	
	@Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String sobrenome;
	private TipoDocumento tipoDeDocumento;
	private String documento;
	private String telefone;
		
	public DadosPessoais() {
		super();
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
	public TipoDocumento getTipoDeDocumento() {
		return tipoDeDocumento;
	}
	public void setTipoDeDocumento(TipoDocumento tipoDeDocumento) {
		this.tipoDeDocumento = tipoDeDocumento;
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
	

	
}

