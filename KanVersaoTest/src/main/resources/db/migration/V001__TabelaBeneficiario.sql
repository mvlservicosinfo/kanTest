CREATE TABLE beneficiario(
                             id LONG auto_increment primary key not null,
                             nome varchar(200) not null,
                             telefone INTEGER,
                             dataNascimento Date,
                             dataInclusao Date,
                             dataAtualizacao Date
);