package com.BlogPessoalGen.BlogPessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BlogPessoalGen.BlogPessoal.model.TemaModel;

@Repository
public interface TemaRepository extends JpaRepository<TemaModel, Long>{
	
	List<TemaModel> findAllByNomeContaining (String nome);
	List<TemaModel> findAllByDescricaoContaining (String descricao);

}
