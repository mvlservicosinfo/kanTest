package br.com.teste.prj.kanversaotest.servicos;


import br.com.teste.prj.kanversaotest.model.Beneficiario;
import br.com.teste.prj.kanversaotest.model.Documento;
import br.com.teste.prj.kanversaotest.repositories.RepBeneficiario;
import br.com.teste.prj.kanversaotest.repositories.RepDocumento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Servicos {
@Autowired
    RepBeneficiario repbeneficiario;
@Autowired
    RepDocumento repDocumento;

    public Beneficiario serv_cadastrar(Beneficiario beneficiario){
       return  repbeneficiario.save(beneficiario);
    }


    public Documento serv_cadastrarDocumento(Documento documento){
        return  repDocumento.save(documento);
    }



    public ResponseEntity<List<Beneficiario>> localizarTodos(){
        List<Beneficiario> beneficiarios = repbeneficiario.findAll();
        return  new ResponseEntity<List<Beneficiario>>(beneficiarios, HttpStatus.OK);
    }

    public ResponseEntity<List<Documento>> localizaPorIDDoc(@PathVariable Long id){
        Documento documento = (Documento) repDocumento.findAllById(Collections.singleton(id));
        return  ResponseEntity.ok().body(Collections.singletonList(documento));
    }

    private Map<Long, Beneficiario> beneficiarioMap = new HashMap<>();


    public ResponseEntity<Beneficiario> atulizarPorID(@PathVariable Long id, @RequestBody Beneficiario beneficiario){
        if (beneficiarioMap.containsKey(id)){
            Beneficiario existente = beneficiarioMap.get(id);
            existente.setNome(beneficiario.getNome());
            existente.setTelefone(beneficiario.getTelefone());
            existente.setDataNascimento(beneficiario.getDataNascimento());
            existente.setDataAtualizacao(beneficiario.getDataAtualizacao());
            existente.setDataInclusao(beneficiario.getDataInclusao());
            return new ResponseEntity<>(existente, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public void remover(Long id) {
        Beneficiario beneficiario = new Beneficiario();
        Documento documento = new Documento();
        if (beneficiario.getDataInclusao().equals(documento.getDataInclusao())) {
            repbeneficiario.deleteById(id);
            repDocumento.deleteById(id);
        }
    }

}
