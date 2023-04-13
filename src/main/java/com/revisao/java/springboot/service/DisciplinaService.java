package com.revisao.java.springboot.service;

import com.revisao.java.springboot.model.entity.Disciplina;
import com.revisao.java.springboot.repository.DisciplinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    private DisciplinaRepository disciplinaRepository;

    public List<Disciplina> findAll() {
        return disciplinaRepository.findAll();
    }

    public <S extends Disciplina> S save(S entity) {
        return disciplinaRepository.save(entity);
    }

    public Optional<Disciplina> findById(Long aLong) {
        return disciplinaRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return disciplinaRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        disciplinaRepository.deleteById(aLong);
    }
}
