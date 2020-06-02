package br.com.ygorteles.aprenda.rest.domain.service;

import br.com.ygorteles.aprenda.rest.domain.model.Endereco;
import br.com.ygorteles.aprenda.rest.domain.model.Pessoa;
import br.com.ygorteles.aprenda.rest.domain.repository.jpa.PessoaRepository;
import br.com.ygorteles.aprenda.rest.web.controller.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    public Pessoa atualizar(Long codigo, Pessoa pessoa) {
        Pessoa pessoaSalva = buscarPessoaPeloCodigo(codigo);
        BeanUtils.copyProperties(pessoa,pessoaSalva, "codigo");
        return pessoaRepository.save(pessoaSalva);
    }

    public void atualizarPropriedadeAtivo(Long codigo, boolean ativo) {
        Pessoa pessoaSalva = buscarPessoaPeloCodigo(codigo);
        pessoaSalva.setAtivo(ativo);
        pessoaRepository.save(pessoaSalva);
    }

    public Pessoa buscarPessoaPeloCodigo(Long codigo) {
        Pessoa pessoaSalva = pessoaRepository.findById(codigo).orElse(null);
        if(pessoaSalva == null){
            throw  new EmptyResultDataAccessException(1);
        }
        return pessoaSalva;
    }
}
