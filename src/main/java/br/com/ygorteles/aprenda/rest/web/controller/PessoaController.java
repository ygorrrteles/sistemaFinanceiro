package br.com.ygorteles.aprenda.rest.web.controller;

import br.com.ygorteles.aprenda.rest.domain.model.Categoria;
import br.com.ygorteles.aprenda.rest.domain.model.Pessoa;
import br.com.ygorteles.aprenda.rest.domain.repository.jpa.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    PessoaRepository pessoaRepository;

    @GetMapping
    public List<Pessoa> listar() {
        return pessoaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Pessoa> criar(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response){
        Pessoa pessoaCriada = pessoaRepository.save(pessoa);

        Utils.setarLocationPost(pessoaCriada.getCodigo(),"/{codigo}", response);
        return ResponseEntity.created(Utils.uri).body(pessoaCriada);
    }
}
