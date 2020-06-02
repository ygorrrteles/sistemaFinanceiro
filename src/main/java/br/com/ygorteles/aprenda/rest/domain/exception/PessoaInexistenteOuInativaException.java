package br.com.ygorteles.aprenda.rest.domain.exception;

public class PessoaInexistenteOuInativaException extends Exception{
    public PessoaInexistenteOuInativaException(String message) {
        super(message);
    }
}
