package com.java.GerenciamentoClientes.controller;

import com.java.GerenciamentoClientes.dto.ClienteDTO;
import com.java.GerenciamentoClientes.model.ClienteModel;
import com.java.GerenciamentoClientes.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<ClienteDTO>> listarClientes(){
        List<ClienteDTO> cliente = clienteService.listarClientes();
        return ResponseEntity.ok(cliente);

    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<ClienteDTO> listarId (@PathVariable Long id){

        Optional<ClienteDTO> cliente = clienteService.listarClienteId(id);

        if(cliente.isPresent()){
            return ResponseEntity.ok(cliente.get());

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<ClienteModel> criarCliente(@RequestBody ClienteDTO cliente){
        ClienteModel novoCliente = clienteService.criarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
    }
    @DeleteMapping("/deletar/{id}")
    public void deletarCliente(@PathVariable Long id){
        clienteService.deletarCliente(id);
    }
    @PutMapping ("/atualizar/{id}")
    public ResponseEntity<ClienteModel> atualizarCliente(@PathVariable Long id, @RequestBody ClienteDTO cliente){
        Optional<ClienteModel> clienteAtualizado = clienteService.atualizarCliente(id,cliente);

        if(clienteAtualizado.isPresent()){
            return ResponseEntity.ok(clienteAtualizado.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
