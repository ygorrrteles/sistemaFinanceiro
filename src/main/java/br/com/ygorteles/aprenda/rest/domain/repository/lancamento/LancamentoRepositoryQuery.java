package br.com.ygorteles.aprenda.rest.domain.repository.lancamento;

import br.com.ygorteles.aprenda.rest.domain.model.Lancamento;
import br.com.ygorteles.aprenda.rest.domain.repository.filter.LancamentoFilter;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface LancamentoRepositoryQuery {
    public List<Lancamento> filtrar(LancamentoFilter lancamentoFilter);
}
