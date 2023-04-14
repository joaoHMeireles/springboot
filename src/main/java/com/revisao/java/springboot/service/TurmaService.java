package com.revisao.java.springboot.service;

import com.revisao.java.springboot.model.entity.Turma;
import com.revisao.java.springboot.repository.TurmaRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Data
@Service
public class TurmaService {

    private TurmaRepository turmaRepository;

    public List<Turma> findAll() {
        return turmaRepository.findAll();
    }

    public <S extends Turma> S save(S entity) {
        return turmaRepository.save(entity);
    }

    public Optional<Turma> findById(Long aLong) {
        return turmaRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return turmaRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        turmaRepository.deleteById(aLong);
    }
}
