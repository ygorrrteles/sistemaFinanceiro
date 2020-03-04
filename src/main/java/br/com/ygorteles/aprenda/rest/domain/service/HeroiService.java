package br.com.ygorteles.aprenda.rest.domain.service;

import br.com.ygorteles.aprenda.rest.domain.exception.YgaoException;
import br.com.ygorteles.aprenda.rest.domain.model.Heroi;
import br.com.ygorteles.aprenda.rest.domain.repository.jpa.HeroiJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class HeroiService {

    @Autowired
    HeroiJpaRepository heroiJpaRepository;

    public Heroi salvar(Heroi heroi) throws YgaoException {

        if(heroi.getNome() == null){
            throw new YgaoException("nao conseguimos inserir no banco");
        }

        return heroiJpaRepository.save(heroi);
    }

    public void deletar(Long id) throws YgaoException {
        try {
            heroiJpaRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new YgaoException("nao conseguimos deletar");
        }

    }

    public Heroi editar(Heroi heroi) {
        return heroiJpaRepository.save(heroi);
    }
}
