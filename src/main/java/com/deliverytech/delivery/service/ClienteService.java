package com.deliverytech.delivery.service;

import com.deliverytech.delivery.dto.ClienteRequestDTO;
import com.deliverytech.delivery.dto.ClienteResponseDTO;
import com.deliverytech.delivery.entity.Cliente;
import com.deliverytech.delivery.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Transactional
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    public ClienteResponseDTO cadastrar(ClienteRequestDTO dto) {
        if(clienteRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("Email já cadastrado: " + dto.getEmail());
        }
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefone(dto.getTelefone());
        cliente.setEndereco(dto.getEndereco());
        cliente.setAtivo(true);
        cliente.setDataCadastro(LocalDateTime.now());
        return new ClienteResponseDTO(clienteRepository.save(cliente));
    }
    @Transactional(readOnly = true)
    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }
    @Transactional(readOnly = true)
    public Optional<Cliente> buscarPorEmail(String email) {
        return clienteRepository.findByEmail(email);
    }
    @Transactional(readOnly = true)
    public List<Cliente> listarAtivos() {
        return clienteRepository.findByAtivoTrue();
    }
    public Cliente atualizar(Long id, Cliente clienteAtualizado) {
        Cliente cliente = buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado: " + id));
        if(!cliente.getEmail().equals(clienteAtualizado.getEmail()) && clienteRepository.existsByEmail(clienteAtualizado.getEmail())) {
            throw new IllegalArgumentException("Email já cadastrado: " + clienteAtualizado.getEmail());
        }
        cliente.setNome(clienteAtualizado.getNome());
        cliente.setEmail(clienteAtualizado.getEmail());
        cliente.setTelefone(clienteAtualizado.getTelefone());
        cliente.setEndereco(clienteAtualizado.getEndereco());
        return clienteRepository.save(cliente);
    }
    public void inativar(Long id) {
        Cliente cliente = buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado: " + id));
        cliente.inativar();
        clienteRepository.save(cliente);
    }
    @Transactional(readOnly = true)
    public List<Cliente> buscarPorNome(String nome) {
        return clienteRepository.findByNomeContainingIgnoreCase(nome);
    }
//    private void validarDadosCliente(Cliente cliente) {
//        if(cliente.getNome() == null || cliente.getNome().trim().isEmpty()) {
//            throw new IllegalArgumentException("Nome é obrigatório");
//        }
//        if(cliente.getEmail() == null || cliente.getEmail().trim().isEmpty()) {
//            throw new IllegalArgumentException("Email é obrigatório");
//        }
//        if(cliente.getNome().length() < 2) {
//            throw new IllegalArgumentException("Nome deve ter pelo menos 2 caracteres");
//        }
//    }
}