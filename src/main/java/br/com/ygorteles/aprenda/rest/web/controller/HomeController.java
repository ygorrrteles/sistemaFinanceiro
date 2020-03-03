package br.com.ygorteles.aprenda.rest.web.controller;

import br.com.ygorteles.aprenda.rest.domain.exception.YgaoException;
import br.com.ygorteles.aprenda.rest.domain.model.Heroi;
import br.com.ygorteles.aprenda.rest.domain.repository.jpa.HeroiJpaRepository;
import br.com.ygorteles.aprenda.rest.domain.service.HeroiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/heroi")
public class HomeController {

    @Autowired
    HeroiService heroiService;

    @Autowired
    HeroiJpaRepository heroiJpaRepository;

    @GetMapping("/index")
    public ResponseEntity<Heroi> index(@RequestParam Long id) {

        return new ResponseEntity<Heroi>(heroiJpaRepository.findById(id).orElse(null), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Heroi>> list() {

        return new ResponseEntity<>(heroiJpaRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Heroi heroi) {
        try {
            return ResponseEntity.ok(heroiService.salvar(heroi));
        } catch (YgaoException e) {
           return ResponseEntity.ok(String.format("OU VIADO NAO PODE DELETAR OQ JA FOI DELETADO, SE LIGA BRIYYYY. SE LIGA NOS DETAHES: %s", e.getLocalizedMessage()));
        }
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam Long id) {
        try {
            heroiService.deletar(id);
        } catch (YgaoException e) {
            return ResponseEntity.ok(String.format("OU VIADO NAO PODE DELETAR OQ JA FOI DELETADO, SE LIGA BRIYYYY. SE LIGA NOS DETAHES: %s", e.getLocalizedMessage()));
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Heroi> update(@RequestBody Heroi heroi) {
        return ResponseEntity.ok(heroiService.editar(heroi));
    }

}
