package br.com.ygorteles.aprenda.rest.web.controller;


import br.com.ygorteles.aprenda.rest.domain.model.Categoria;
import br.com.ygorteles.aprenda.rest.domain.repository.jpa.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaContoller {

    @Autowired
    CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }
}
