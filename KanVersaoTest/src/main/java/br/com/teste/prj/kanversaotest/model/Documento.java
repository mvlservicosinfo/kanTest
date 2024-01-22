package br.com.teste.prj.kanversaotest.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Table(name="documento")
@Getter
@Setter
@EqualsAndHashCode
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    Long id;
    char tipoDocumento;
    String descricao;
    Date dataInclusao;
    Date dataAtualizacao;

    public Documento() {

    }
}
