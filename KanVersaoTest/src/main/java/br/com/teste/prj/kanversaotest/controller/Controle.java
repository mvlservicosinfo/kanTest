package br.com.teste.prj.kanversaotest.controller;


import br.com.teste.prj.kanversaotest.model.Beneficiario;
import br.com.teste.prj.kanversaotest.model.Documento;
import br.com.teste.prj.kanversaotest.servicos.Servicos;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


@RestController
@Api(value="Cadastro de um Plano de Saúde")
@RequestMapping(value="/api")
public class Controle extends Servicos {


    private Servicos servicos;

    @ApiOperation(value="Gravar Beneficiário")
    @PostMapping(path = "/gravar")
    public void cadastrar(@RequestBody Beneficiario beneficiario, @RequestBody Documento documento){
       servicos.serv_cadastrar(beneficiario);
       servicos. serv_cadastrarDocumento(documento);
    }

    @ApiOperation(value="EndpointLocalizar Todos os Beneficiários")
    @GetMapping(value="/localizartodos")
    public void localizar(){
        servicos.localizarTodos();
    }

    @ApiOperation(value="Endpoint Localizar por ID")
    @GetMapping(path="/localizarporid/{id}")
    public void localizaporId(@PathVariable Long id){
        servicos.localizaPorIDDoc(id);
    }

    @ApiOperation(value="Endpoint Atualizar por ID")
    @PutMapping(path="/atualizarporid/{id}")
    public void atuliza(@PathVariable Long id, @RequestBody Beneficiario beneficiario) {
        servicos.atulizarPorID(id,beneficiario);
    }

    @ApiOperation(value="Endpoint Apagar por ID")
    @DeleteMapping(path="/apagarporid/{id}")
    public void apagar(@PathVariable Long id){
        servicos.remover(id);
    }
}
