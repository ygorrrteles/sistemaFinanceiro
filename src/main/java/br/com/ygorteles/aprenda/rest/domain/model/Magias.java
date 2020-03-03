package br.com.ygorteles.aprenda.rest.domain.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Magias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
}
