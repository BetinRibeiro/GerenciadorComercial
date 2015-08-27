package br.com.Bin.Pessoa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import br.com.Bin.Endereco;
import br.com.Bin.Telefone;
import br.com.Persistence.Banco;

@MappedSuperclass
@Table(name = "pessoa")
public class Pessoa implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Integer id;
	@Column(name = "email")
	private String email;
	@Column(name = "endereco")
	private Integer endereco;
	@Column(name = "fone")
	private Integer fone;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Telefone getFone() {
		Banco banco = new Banco();
		return (Telefone) banco.buscarPorId(
				Telefone.class, fone);
	}
	public void setFone(Telefone fone) {
		this.fone = fone.getId();;
	}
	public Endereco getEnd() {
		Banco banco = new Banco();
		return (Endereco) banco.buscarPorId(
				Endereco.class, endereco);
	}
	public void setEnd(Endereco end) {
		this.endereco = end.getId();
		System.out.println("aqui"+this.endereco);;
	}

}
