package com.altf4tecnologia.produtos.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String prod_nome;
	private String prod_descricao;

	public Produto() {}

	public Produto(String prod_nome, String prod_descricao) {
		super();
		this.prod_nome = prod_nome;
		this.prod_descricao = prod_descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProd_nome() {
		return prod_nome;
	}

	public void setProd_nome(String prod_nome) {
		this.prod_nome = prod_nome;
	}

	public String getProd_descricao() {
		return prod_descricao;
	}

	public void setProd_descricao(String prod_descricao) {
		this.prod_descricao = prod_descricao;
	}

}
