package br.com.teste.prj.kanversaotest.repositories;



import br.com.teste.prj.kanversaotest.model.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepDocumento extends JpaRepository<Documento,Long> {

}
