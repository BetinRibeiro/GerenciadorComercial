package br.com.Bin.Produto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.Persistence.Banco;


@Entity
@Table(name = "produto")
public class Produto {
	// não uso exatamente a chave estrageira no hibernate, mas isso pode ser
	// facilmente alterado
	// fis de forma manual agente passa uma classe e ele salva só o id, no
	// retorno é a mesma coisa ele retorna a classe, tem um problema pois quando
	// for deletado o banco não entende que se trata de uma chave estrageira

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Integer id;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "estoquemin")
	private float estoqueMin;

	@Column(name = "preco")
	private float preco;

	@Column(name = "custo")
	private float custo;

	@Column(name = "quantidade")
	private float quantidade;

	@Column(name = "localizacao")
	private Integer localizacao;

	@Column(name = "classificacao")
	private Integer classificacao;

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getEstoqueMin() {
		return estoqueMin;
	}

	public void setEstoqueMin(float estoqueMin) {
		this.estoqueMin = estoqueMin;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public float getCusto() {
		return custo;
	}

	public void setCusto(float custo) {
		this.custo = custo;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	public LocalizacaoProduto getLocalizacao() {
		 Banco banco = new Banco();
		return (LocalizacaoProduto) banco.buscarPorId(LocalizacaoProduto.class,
				localizacao);
	}

	public void setLocalizacao(LocalizacaoProduto localizacao) {
		this.localizacao = localizacao.getId();
	}

	public ClassificacaoProduto getClassificacao() {
		 Banco banco = new Banco();
		return (ClassificacaoProduto) banco.buscarPorId(
				ClassificacaoProduto.class, classificacao);
	}

	public void setClassificacao(ClassificacaoProduto classificacao) {
		this.classificacao = classificacao.getId();
	}

}
