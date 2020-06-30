package com.altf4tecnologia.produtos.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.altf4tecnologia.produtos.modelo.Produto;


public class ProdutoForm {
	
	private Long id;
    @NotNull @NotEmpty
	private String prod_nome;
    @NotNull @NotEmpty
	private String prod_descricao;
	
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
	public Produto converter() {
        
		return new Produto(prod_nome, prod_descricao);
	}

	
}
