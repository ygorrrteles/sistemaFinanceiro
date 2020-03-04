package br.com.ygorteles.aprenda.rest.domain.service;

import br.com.ygorteles.aprenda.rest.domain.repository.jpa.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;
}
