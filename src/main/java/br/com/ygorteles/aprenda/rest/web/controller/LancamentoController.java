package br.com.ygorteles.aprenda.rest.web.controller;

import br.com.ygorteles.aprenda.rest.domain.exception.PessoaInexistenteOuInativaException;
import br.com.ygorteles.aprenda.rest.domain.exception.YgaoException;
import br.com.ygorteles.aprenda.rest.domain.model.Lancamento;
import br.com.ygorteles.aprenda.rest.domain.model.Pessoa;
import br.com.ygorteles.aprenda.rest.domain.repository.jpa.LancamentoRepository;
import br.com.ygorteles.aprenda.rest.domain.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    @Autowired
    LancamentoService lancamentoService;

    @GetMapping
    public List<Lancamento> listar(){
        return lancamentoService.buscarTodos();
    }

    @GetMapping("/{codigo}")
    public Lancamento buscar(@PathVariable Long codigo) {
        return lancamentoService.buscarUm(codigo);
    }

    @PostMapping
    public ResponseEntity<?> criar(@Valid @RequestBody Lancamento lancamento, HttpServletResponse response){
        Lancamento lancamentoCriado = null;
        try{
            lancamentoCriado = lancamentoService.salvar(lancamento);

        }catch (PessoaInexistenteOuInativaException e){
            return ResponseEntity.ok(String.format("Pessoa inexistente ou inativa: %s", e.getLocalizedMessage()));
        }

        Utils.setarLocationPost(lancamentoCriado.getCodigo(),"/{codigo}", response);
        return ResponseEntity.created(Utils.uri).body(lancamentoCriado);
    }
}
