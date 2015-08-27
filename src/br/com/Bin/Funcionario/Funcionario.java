package br.com.Bin.Funcionario;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.Bin.Pessoa.Pessoa;
import br.com.Persistence.Banco;

@Entity
@Table(name = "funcionario")

public class Funcionario extends Pessoa{
	
	@Column(name = "nome")
	private String nome;
	@Column(name = "sobrenome")
	private String sobrenome;
	@Column(name = "rg")
	private String rg;
	@Column(name = "cpf")
	private String cpf;
	@Column(name = "estado_civil")
	private String estadoCivil;
	@Column(name = "sexo")
	private String sexo;
	@Column(name = "escolaridade")
	private String escolaridade;
	@Column(name = "data_nasc")
	private Date dataNasc;
	@Column(name = "valor_salario")
	private float valorSalario;
	@Column(name = "cargo")
	private Integer cargo;
	
	public Cargo getCargo() {
		Banco banco = new Banco();
		return (Cargo) banco.buscarPorId(
				Cargo.class, cargo);
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo.getId();;
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
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEscolaridade() {
		return escolaridade;
	}
	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}
	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	public float getValorSalario() {
		return valorSalario;
	}
	public void setValorSalario(float valorSalario) {
		this.valorSalario = valorSalario;
	}
	
	
	
	
	
	

}
