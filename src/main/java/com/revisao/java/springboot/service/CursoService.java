package com.revisao.java.springboot.service;

import com.revisao.java.springboot.model.entity.Curso;
import com.revisao.java.springboot.repository.CursoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Data
@Service
public class CursoService {

    private CursoRepository cursoRepository;

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    public <S extends Curso> S save(S entity) {
        return cursoRepository.save(entity);
    }

    public Optional<Curso> findById(Long aLong) {
        return cursoRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return cursoRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        cursoRepository.deleteById(aLong);
    }
}
