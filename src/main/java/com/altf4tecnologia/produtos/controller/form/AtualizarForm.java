package com.altf4tecnologia.produtos.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.altf4tecnologia.produtos.modelo.Produto;
import com.altf4tecnologia.produtos.repository.ProdutoRepository;


public class AtualizarForm {

    @NotNull @NotEmpty @Length(min = 2)
	private String prod_nome;
    @NotNull @NotEmpty 
	private String prod_descricao;
	
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
	public Produto atualizar(Long id, ProdutoRepository produtoRepository) {
		Produto produto = produtoRepository.getOne(id);
		
		produto.setProd_nome(this.prod_nome);
		produto.setProd_descricao(this.prod_descricao);
		
		return produto;
	}
	
}
