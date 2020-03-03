package br.com.ygorteles.aprenda.rest.domain.repository.jpa;

import br.com.ygorteles.aprenda.rest.domain.model.Heroi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroiJpaRepository extends JpaRepository<Heroi, Long> {

}
