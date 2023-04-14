package com.revisao.java.springboot.service;

import com.revisao.java.springboot.model.entity.Professor;
import com.revisao.java.springboot.repository.ProfessorRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Data
@Service
public class ProfessorService {

    private ProfessorRepository professorRepository;

    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    public <S extends Professor> S save(S entity) {
        return professorRepository.save(entity);
    }

    public Optional<Professor> findById(Long aLong) {
        return professorRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return professorRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        professorRepository.deleteById(aLong);
    }
}
