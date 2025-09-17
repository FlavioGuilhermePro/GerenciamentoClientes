package com.java.GerenciamentoClientes.service;

import com.java.GerenciamentoClientes.dto.ClienteDTO;
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

    public ClienteModel criarCliente(ClienteDTO clienteDTO){
        ClienteModel cliente = new ClienteModel();
        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setIdade(clienteDTO.getIdade());
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


    public ClienteModel criarCliente (ClienteModel cliente){
        return clienteRepository.save(cliente);
    }

    public Optional<ClienteModel> atualizarCliente(Long id ,ClienteModel cliente){
        Optional<ClienteModel> clienteOptional = clienteRepository.findById(id);
        if(clienteOptional.isPresent()){
            ClienteModel clienteExistente = clienteOptional.get();
            clienteExistente.setNome(cliente.getNome());
            clienteExistente.setEmail(cliente.getEmail());
            clienteExistente.setIdade(cliente.getIdade());

            ClienteModel clienteAtualizado = clienteRepository.save(clienteExistente);
            return Optional.of(clienteAtualizado);
        } else {
            return Optional.empty();
        }
    }

}
