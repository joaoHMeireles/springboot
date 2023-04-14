package com.revisao.java.springboot.controller;

import com.revisao.java.springboot.model.dto.ProfessorDTO;
import com.revisao.java.springboot.model.entity.Professor;
import com.revisao.java.springboot.service.ProfessorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@AllArgsConstructor
@Controller
@RequestMapping("/professor")
public class ProfessorController {
    private ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<Professor>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(professorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(name = "id") Long idProfessor) {
        if (!professorService.existsById(idProfessor)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum Professor com o ID informado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(professorService.findById(idProfessor));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid ProfessorDTO professorDTO) {
        Professor professor = new Professor();
        BeanUtils.copyProperties(professorDTO, professor);
        return ResponseEntity.status(HttpStatus.OK).body(professorService.save(professor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> edit(@RequestBody @Valid  ProfessorDTO professorDTO, @PathVariable(name = "id") Long idProfessor) {
        if (!professorService.existsById(idProfessor)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum Professor com o ID informado");
        }

        Professor professor = professorService.findById(idProfessor).get();
        BeanUtils.copyProperties(professorDTO, professor);
        professor.setId(idProfessor);

        return ResponseEntity.status(HttpStatus.OK).body(professorService.save(professor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Long idProfessor) {
        if (!professorService.existsById(idProfessor)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum Professor com o ID informado");
        }
        professorService.deleteById(idProfessor);
        return ResponseEntity.status(HttpStatus.OK).body("Professor deletado com sucesso!");
    }
}
