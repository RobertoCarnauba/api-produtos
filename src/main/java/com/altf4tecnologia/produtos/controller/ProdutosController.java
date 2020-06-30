package com.altf4tecnologia.produtos.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.altf4tecnologia.produtos.controller.dto.ProdutoDTO;
import com.altf4tecnologia.produtos.controller.form.AtualizarForm;
import com.altf4tecnologia.produtos.controller.form.ProdutoForm;
import com.altf4tecnologia.produtos.modelo.Produto;
import com.altf4tecnologia.produtos.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping
	public List<ProdutoDTO> lista(){
		
		List<Produto> produtos = produtoRepository.findAll();
		return ProdutoDTO.converter(produtos);
	}
	
	@PostMapping
	public ResponseEntity<ProdutoDTO> cadastrar(@RequestBody @Valid ProdutoForm form, UriComponentsBuilder uriBuilder) {
		
	   Produto produto = form.converter();
	   produtoRepository.save(produto);
	   
	   URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
	   return ResponseEntity.created(uri).body(new ProdutoDTO(produto));
	}
	
	@GetMapping("/{id}")
	public ProdutoDTO detalhar(@PathVariable Long id) {

		Produto produto = produtoRepository.getOne(id);
		return new ProdutoDTO(produto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProdutoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarForm form) {
	    Optional<Produto> optional = produtoRepository.findById(id);
	    if (optional.isPresent()) {
	    	Produto produto = form.atualizar(id, produtoRepository);
	        produtoRepository.save(produto);
	        return ResponseEntity.ok(new ProdutoDTO(produto));
	    }

	    return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	private ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Produto> optional = produtoRepository.findById(id);
		if(optional.isPresent()) {
			produtoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
}
