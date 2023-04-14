package com.revisao.java.springboot.controller;

import com.revisao.java.springboot.model.dto.DisciplinaDTO;
import com.revisao.java.springboot.model.entity.Disciplina;
import com.revisao.java.springboot.service.DisciplinaService;
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
@RequestMapping("/disciplina")
public class DisciplinaController {
    private DisciplinaService disciplinaService;

    @GetMapping
    public ResponseEntity<List<Disciplina>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(name = "id") Long idDisciplina) {
        if (!disciplinaService.existsById(idDisciplina)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhuma Disciplina com o ID informado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.findById(idDisciplina));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid DisciplinaDTO disciplinaDTO) {
        Disciplina disciplina = new Disciplina();
        BeanUtils.copyProperties(disciplinaDTO, disciplina);
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.save(disciplina));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> edit(@RequestBody @Valid DisciplinaDTO disciplinaDTO, @PathVariable(name = "id") Long idDisciplina) {
        if (!disciplinaService.existsById(idDisciplina)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhuma Disciplina com o ID informado");
        }

        Disciplina disciplina = disciplinaService.findById(idDisciplina).get();
        BeanUtils.copyProperties(disciplinaDTO, disciplina);
        disciplina.setId(idDisciplina);

        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.save(disciplina));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Long idDisciplina) {
        if (!disciplinaService.existsById(idDisciplina)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhuma Disciplina com o ID informado");
        }
        disciplinaService.deleteById(idDisciplina);
        return ResponseEntity.status(HttpStatus.OK).body("Disciplina deletado com sucesso!");
    }
}
