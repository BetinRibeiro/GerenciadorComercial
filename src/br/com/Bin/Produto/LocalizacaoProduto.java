package br.com.Bin.Produto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "localizacao_produto")
public class LocalizacaoProduto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Integer id;

	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "obs")
	private String obsLocal;

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

	public String getObsLocal() {
		return obsLocal;
	}

	public void setObsLocal(String obsLocal) {
		this.obsLocal = obsLocal;
	}

	
}
