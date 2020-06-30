package br.com.ygorteles.aprenda.rest.domain.service;

import br.com.ygorteles.aprenda.rest.domain.exception.PessoaInexistenteOuInativaException;
import br.com.ygorteles.aprenda.rest.domain.exception.YgaoException;
import br.com.ygorteles.aprenda.rest.domain.model.Lancamento;
import br.com.ygorteles.aprenda.rest.domain.model.Pessoa;
import br.com.ygorteles.aprenda.rest.domain.repository.jpa.LancamentoRepository;
import br.com.ygorteles.aprenda.rest.domain.repository.jpa.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;


@Service
public class LancamentoService {

    @Autowired
    LancamentoRepository lancamentoRepository;

    @Autowired
    PessoaRepository pessoaRepository;

    public Page<Lancamento> buscarTodos(Pageable pageable) {

        return lancamentoRepository.findAll(pageable);
    }

    public Lancamento buscarUm(Long codigo) {
        Lancamento lancamentoSalvo = lancamentoRepository.findById(codigo).orElse(null);
        if(lancamentoSalvo == null){
            throw new EmptyResultDataAccessException(1);
        }
        return lancamentoSalvo;
    }

    public Lancamento salvar(Lancamento lancamento) throws PessoaInexistenteOuInativaException {
        Pessoa pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo()).orElse(null);

        if(pessoa == null || !pessoa.getAtivo()) {
            throw new PessoaInexistenteOuInativaException("Teste");
        }

        return lancamentoRepository.save(lancamento);
    }
}
