package br.com.Bin;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.Bin.Fornecedor.Fornecedor;
import br.com.Bin.Pessoa.Pessoa;
import br.com.Persistence.Banco;

@Entity
@Table(name = "contato")
public class Contato extends Pessoa{
	private String nome;
	private String sobrenome;
	private String sexo;
	private Integer fornecedor;
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
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Fornecedor getFornecedor() {
		Banco banco = new Banco();
		return (Fornecedor) banco.buscarPorId(
				Fornecedor.class, fornecedor);
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor.getId();
	}
	
	
	

}
