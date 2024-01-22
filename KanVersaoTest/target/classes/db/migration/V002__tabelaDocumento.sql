create table documento
(
    id              LONG auto_increment primary key not null,
    tipoDocumento   char(1),
    descricao       varchar(200),
    dataInclusao    Date,
    dataAtualizacao Date
);