package br.com.ygorteles.aprenda.rest.web.controller;


import br.com.ygorteles.aprenda.rest.domain.model.Categoria;
import br.com.ygorteles.aprenda.rest.domain.repository.jpa.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
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

    @PostMapping
    public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria categoria, HttpServletResponse response){
        Categoria categoriaCriada = categoriaRepository.save(categoria);

        Utils.setarLocationPost(categoriaCriada.getCodigo(),"/{codigo}", response);
        return ResponseEntity.created(Utils.uri).body(categoriaCriada);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Categoria> buscarPeloCodigo(@PathVariable Long codigo){
        return new ResponseEntity<>(categoriaRepository.findById(codigo).orElse(null), HttpStatus.OK);
    }
}
