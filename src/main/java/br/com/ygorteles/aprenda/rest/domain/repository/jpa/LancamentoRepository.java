package br.com.ygorteles.aprenda.rest.domain.repository.jpa;

import br.com.ygorteles.aprenda.rest.domain.model.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
}
