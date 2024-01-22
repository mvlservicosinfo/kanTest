package br.com.teste.prj.kanversaotest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name="beneficiario")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Beneficiario {

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private List<Documento> documento;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    Long id;
    String nome;
    Integer telefone;
    Date dataNascimento;
    Date dataInclusao;
    Date DataAtualizacao;



}
