package br.com.ygorteles.aprenda.rest.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
public class Heroi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int agilidade;
    private int inteligencia;
    private int forca;
    private int level;

    @Transient
    private List<Item> items;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Magias> magias;
}
