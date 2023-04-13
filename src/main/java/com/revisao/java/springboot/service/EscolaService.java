package com.revisao.java.springboot.service;

import com.revisao.java.springboot.model.entity.Escola;
import com.revisao.java.springboot.repository.EscolaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EscolaService {

    private EscolaRepository escolaRepository;

    public List<Escola> findAll() {
        return escolaRepository.findAll();
    }

    public <S extends Escola> S save(S entity) {
        return escolaRepository.save(entity);
    }

    public Optional<Escola> findById(Long aLong) {
        return escolaRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return escolaRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        escolaRepository.deleteById(aLong);
    }
}
