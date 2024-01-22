package br.com.teste.prj.kanversaotest.repositories;

import br.com.teste.prj.kanversaotest.model.Beneficiario;
import br.com.teste.prj.kanversaotest.model.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepBeneficiario extends JpaRepository<Beneficiario,Long> {

}
