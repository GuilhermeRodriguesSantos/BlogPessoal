package com.BlogPessoalGen.BlogPessoal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BlogPessoalGen.BlogPessoal.model.TemaModel;
import com.BlogPessoalGen.BlogPessoal.repository.TemaRepository;

@RestController
@RequestMapping("/Tema")
public class TemaController {

	@Autowired
	private TemaRepository repository;

	@GetMapping("/buscarTodos")
	public ResponseEntity<List<TemaModel>> BuscarTodos() {
		return ResponseEntity.status(200).body(repository.findAll());
	}

	@GetMapping("/BucarPeloNome")
	public ResponseEntity<List<TemaModel>> BucarNome(@RequestParam(defaultValue = "") String nome) {
		return ResponseEntity.status(200).body(repository.findAllByNomeContaining(nome));
	}

	@GetMapping("/BuscarPelaDescricao")
	public ResponseEntity<List<TemaModel>> BuscarDescricao(@RequestParam(defaultValue = "") String descricao) {
		return ResponseEntity.status(200).body(repository.findAllByDescricaoContaining(descricao));
	}

	@GetMapping("/BucarPelodID/{id}")
	public ResponseEntity<TemaModel> BuscarPeloId(@PathVariable Long id) {
		return repository.findById(id).map(achou -> ResponseEntity.ok(achou))
				.orElse(ResponseEntity.status(HttpStatus.NO_CONTENT).build());
	}

	@DeleteMapping("/deletar/{id}")
	public void Deletar(@PathVariable Long id) {
		repository.deleteById(id);
	}

	@PostMapping("/Adicionar")
	public ResponseEntity<TemaModel> Adicionar(@Valid @RequestBody TemaModel novoTema) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(novoTema));
	}

	@PutMapping("/Alterar/{id}")
	public ResponseEntity<TemaModel> alterar(@Valid @RequestBody TemaModel novoTema) {
		return ResponseEntity.status(200).body(repository.save(novoTema));
	}

}
