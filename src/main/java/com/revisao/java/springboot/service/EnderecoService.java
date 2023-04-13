package com.revisao.java.springboot.service;

import com.revisao.java.springboot.model.entity.Endereco;
import com.revisao.java.springboot.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    private EnderecoRepository enderecoRepository;

    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    public <S extends Endereco> S save(S entity) {
        return enderecoRepository.save(entity);
    }

    public Optional<Endereco> findById(Long aLong) {
        return enderecoRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return enderecoRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        enderecoRepository.deleteById(aLong);
    }
}
