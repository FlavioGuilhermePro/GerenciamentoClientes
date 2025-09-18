package com.java.GerenciamentoClientes.controller;

import com.java.GerenciamentoClientes.dto.ClienteDTO;
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
    public List<ClienteDTO> listarClientes(){
        return clienteService.listarClientes();
    }

    @GetMapping("/listar/{id}")
    public Optional<ClienteDTO> listarId (@PathVariable Long id){
        return clienteService.listarClienteId(id);
    }

    @PostMapping("/criar")
    public ClienteModel criarCliente (@RequestBody ClienteDTO cliente){
        return clienteService.criarCliente(cliente);
    }
    @DeleteMapping("/deletar/{id}")
    public void deletarCliente(@PathVariable Long id){
        clienteService.deletarCliente(id);
    }
    @PutMapping ("/atualizar/{id}")
    public Optional<ClienteModel> atualizarCliente(@PathVariable Long id, @RequestBody ClienteDTO cliente){
        return clienteService.atualizarCliente(id,cliente);
    }


}
