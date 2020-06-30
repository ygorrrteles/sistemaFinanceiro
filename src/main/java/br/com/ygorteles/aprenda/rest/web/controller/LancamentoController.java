package br.com.ygorteles.aprenda.rest.web.controller;

import br.com.ygorteles.aprenda.rest.domain.exception.PessoaInexistenteOuInativaException;
import br.com.ygorteles.aprenda.rest.domain.exception.YgaoException;
import br.com.ygorteles.aprenda.rest.domain.model.Lancamento;
import br.com.ygorteles.aprenda.rest.domain.model.Pessoa;
import br.com.ygorteles.aprenda.rest.domain.repository.filter.LancamentoFilter;
import br.com.ygorteles.aprenda.rest.domain.repository.jpa.LancamentoRepository;
import br.com.ygorteles.aprenda.rest.domain.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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

    @Autowired
    LancamentoRepository lancamentoRepository;

    @GetMapping
    public Page<Lancamento> listar(Pageable pageable){

        return lancamentoService.buscarTodos(pageable);
    }

    @GetMapping("/{codigo}")
    public Lancamento buscar(@PathVariable Long codigo) {
        return lancamentoService.buscarUm(codigo);
    }

//    @GetMapping()
//    public List<Lancamento> pesquisar(LancamentoFilter lancamentoFilter) {
//        return lancamentoRepository.filtrar(lancamentoFilter);
//    }

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

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long codigo) {
        lancamentoRepository.deleteById(codigo);
    }
}
