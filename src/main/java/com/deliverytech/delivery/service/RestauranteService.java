package com.deliverytech.delivery.service;

import com.deliverytech.delivery.entity.Restaurante;
import com.deliverytech.delivery.entity.RestauranteDTO;
import com.deliverytech.delivery.repository.PedidoRepository;
import com.deliverytech.delivery.repository.ProdutoRepository;
import com.deliverytech.delivery.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.*;

@Service
public class RestauranteService {
    @Autowired
    private RestauranteRepository restauranteRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    public Restaurante cadastrar(Restaurante restaurante) {
        if(restauranteRepository.findByNome(restaurante.getNome()).isPresent()) {
            throw new IllegalArgumentException("Restaurante já cadastrado: " + restaurante.getNome());
        }
        validarDadosRestaurante(restaurante);
        restaurante.setAtivo(true);
        return restauranteRepository.save(restaurante);
    }
    @Transactional(readOnly = true)
    public Optional<Restaurante> buscarPorId(Long id) {
        return restauranteRepository.findById(id);
    }
    @Transactional(readOnly = true)
    public Optional<RestauranteDTO> findById(Long id) {
        Optional<Restaurante> byId = restauranteRepository.findById(id);
        if(byId.isEmpty()) {
            return Optional.empty();
        }
        return byId.map(restaurante -> new RestauranteDTO(restaurante.getId(), restaurante.getNome(), restaurante.getCategoria(), restaurante.getEndereco(), restaurante.getTelefone(), restaurante.getTaxaEntrega(), restaurante.getAvaliacao(), restaurante.getAtivo()));
    }
    @Transactional(readOnly = true)
    public List<RestauranteDTO> listarAtivos() {
        List<Restaurante> byAtivoTrue = restauranteRepository.findByAtivoTrue();
        if(byAtivoTrue.isEmpty()) {
            throw new IllegalArgumentException("Nenhum restaurante ativo encontrado");
        }
        return byAtivoTrue.stream().map(restaurante -> new RestauranteDTO(restaurante.getId(), restaurante.getNome(), restaurante.getCategoria(), restaurante.getEndereco(), restaurante.getTelefone(), restaurante.getTaxaEntrega(), restaurante.getAvaliacao(), restaurante.getAtivo())).toList();
    }
    @Transactional(readOnly = true)
    public List<RestauranteDTO> buscarPorCategoria(String categoria) {
        List<Restaurante> byCategoria = restauranteRepository.findByCategoria(categoria);
        if(byCategoria.isEmpty()) {
            throw new IllegalArgumentException("Nenhum restaurante encontrado para a categoria: " + categoria);
        }
        return byCategoria.stream().map(restaurante -> new RestauranteDTO(restaurante.getId(), restaurante.getNome(), restaurante.getCategoria(), restaurante.getEndereco(), restaurante.getTelefone(), restaurante.getTaxaEntrega(), restaurante.getAvaliacao(), restaurante.getAtivo())).toList();
    }
    public Restaurante atualizar(Long id, Restaurante restauranteAtualizado) {
        Restaurante restaurante = buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("Restaurante não encontrado: " + id));
        if(!restaurante.getNome().equals(restauranteAtualizado.getNome()) && restauranteRepository.findByNome(restauranteAtualizado.getNome()).isPresent()) {
            throw new IllegalArgumentException("Nome já cadastrado: " + restauranteAtualizado.getNome());
        }
        restaurante.setNome(restauranteAtualizado.getNome());
        restaurante.setCategoria(restauranteAtualizado.getCategoria());
        restaurante.setEndereco(restauranteAtualizado.getEndereco());
        restaurante.setTelefone(restauranteAtualizado.getTelefone());
        restaurante.setTaxaEntrega(restauranteAtualizado.getTaxaEntrega());
        return restauranteRepository.save(restaurante);
    }
    public void inativar(Long id) {
        Restaurante restaurante = buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("Restaurante não encontrado: " + id));
        restaurante.setAtivo(false);
        restauranteRepository.save(restaurante);
    }
    private void validarDadosRestaurante(Restaurante restaurante) {
        if(restaurante.getNome() == null || restaurante.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
        if(restaurante.getTaxaEntrega() != null && restaurante.getTaxaEntrega().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Taxa de entrega não pode ser negativa");
        }
    }
    public void deletar(Long id) {
        Restaurante restaurante = buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("Restaurante não encontrado: " + id));
        restauranteRepository.delete(restaurante);
    }
}