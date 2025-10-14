package br.fiap.assistencia_tecnica.web.controller;

import br.fiap.assistencia_tecnica.domain.Cliente;
import br.fiap.assistencia_tecnica.service.ClienteService;
import br.fiap.assistencia_tecnica.web.dto.ClienteRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente criar(@RequestBody ClienteRequest requesicao){

        Cliente cliente = new Cliente();
        cliente.setId(requesicao.getId());
        cliente.setNome(requesicao.getNome());
        cliente.setEmail(requesicao.getEmail());
        cliente.setTelefone(requesicao.getTelefone());
        cliente.setSenha(requesicao.getSenha());

        return service.salvar(cliente);
    }
}
