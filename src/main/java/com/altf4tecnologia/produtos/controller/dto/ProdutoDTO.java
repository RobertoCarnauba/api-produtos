package com.altf4tecnologia.produtos.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.altf4tecnologia.produtos.modelo.Produto;

public class ProdutoDTO {

	private Long id;
	private String prod_nome;
	private String prod_descricao;
	
	public ProdutoDTO(Produto produto) {
		this.id = produto.getId();
		this.prod_nome = produto.getProd_nome();
		this.prod_descricao = produto.getProd_descricao();
	}
	
	public Long getId() {
		return id;
	}
	public String getProd_nome() {
		return prod_nome;
	}
	public String getProd_descricao() {
		return prod_descricao;
	}

	public static List<ProdutoDTO> converter(List<Produto> produtos) {
		return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
	}
	
	
}
