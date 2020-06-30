package com.altf4tecnologia.produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.altf4tecnologia.produtos.modelo.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
