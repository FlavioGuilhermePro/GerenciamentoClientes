package com.java.GerenciamentoClientes.controller;

import com.java.GerenciamentoClientes.model.ClienteModel;
import com.java.GerenciamentoClientes.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/clientes")
public class ClienteController {
    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/listar")
    public List<ClienteModel> listarClientes(){
        return clienteService.listarClientes();
    }

    @GetMapping("/listar/{id}")
    public Optional<ClienteModel> listarId (@PathVariable Long id){
        return clienteService.listarClienteId(id);
    }

    @PostMapping("/criar")
    public ClienteModel criarCliente (@RequestBody ClienteModel cliente){
        return clienteService.criarCliente(cliente);
    }
    @DeleteMapping("/deletar/{id}")
    public void deletarCliente(@PathVariable Long id){
        clienteService.deletarCliente(id);
    }
    @PutMapping ("/atualizar/{id}")
    public Optional<ClienteModel> atualizarCliente(@PathVariable Long id, @RequestBody ClienteModel cliente){
        return clienteService.atualizarCliente(id,cliente);
    }


}
