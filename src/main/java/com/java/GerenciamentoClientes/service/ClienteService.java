package com.java.GerenciamentoClientes.service;

import com.java.GerenciamentoClientes.model.ClienteModel;
import com.java.GerenciamentoClientes.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteModel salvarCliente (ClienteModel cliente){
        return clienteRepository.save(cliente);
    }

    public List<ClienteModel> listarClientes(){
        return clienteRepository.findAll();
    }

    public Optional<ClienteModel> listarClienteId(Long id){
        return clienteRepository.findById(id);
    }

    public void deletarCliente(Long id){
        clienteRepository.deleteById(id);
    }


}
