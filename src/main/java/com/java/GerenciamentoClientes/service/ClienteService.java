package com.java.GerenciamentoClientes.service;

import com.java.GerenciamentoClientes.dto.ClienteDTO;
import com.java.GerenciamentoClientes.model.ClienteModel;
import com.java.GerenciamentoClientes.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<ClienteDTO> listarClientes() {
        return clienteRepository.findAll().stream()
                .map(cliente -> {
                    ClienteDTO dto = new ClienteDTO();
                    dto.setNome(cliente.getNome());
                    dto.setEmail(cliente.getEmail());
                    dto.setIdade(cliente.getIdade());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public Optional<ClienteDTO> listarClienteId(Long id){
        return clienteRepository.findById(id)
                .map(cliente -> {
                    ClienteDTO dto = new ClienteDTO();
                    dto.setNome(cliente.getNome());
                    dto.setEmail(cliente.getEmail());
                    dto.setIdade(cliente.getIdade());
                    return dto;
                });
    }

    public void deletarCliente(Long id){
        clienteRepository.deleteById(id);
    }

    public Optional<ClienteModel> atualizarCliente(Long id ,ClienteDTO cliente){
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
