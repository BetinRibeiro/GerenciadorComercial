package br.com.Bin.Fornecedor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.Bin.Cargo;
import br.com.Bin.Pessoa.Pessoa;
import br.com.Persistence.Banco;

@Entity
@Table(name = "fornecedor")
public class Fornecedor extends Pessoa{
	@Column(name = "razao_social")
	private String razaoSocial;
	@Column(name = "nome_fatasia")
	private String nomeFantasia;
	@Column(name = "inscricao_estadual")
	private String inscEstadual;
	@Column(name = "cnpj")
	private String cnpj;
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getInscEstadual() {
		return inscEstadual;
	}
	public void setInscEstadual(String inscEstadual) {
		this.inscEstadual = inscEstadual;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
	

}
