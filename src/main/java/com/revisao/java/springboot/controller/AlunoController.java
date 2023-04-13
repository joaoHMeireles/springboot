package com.revisao.java.springboot.controller;

import com.revisao.java.springboot.model.dto.AlunoDTO;
import com.revisao.java.springboot.model.entity.Aluno;
import com.revisao.java.springboot.service.AlunoService;
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
@RequestMapping("/aluno")
public class AlunoController {
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(name = "id") Long idAluno) {
        if (!alunoService.existsById(idAluno)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum Aluno com o ID informado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.findById(idAluno));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno();
        BeanUtils.copyProperties(alunoDTO, aluno);
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.save(aluno));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> edit(@RequestBody @Valid AlunoDTO alunoDTO, @PathVariable(name = "id") Long idAluno) {
        if (!alunoService.existsById(idAluno)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum Aluno com o ID informado");
        }

        Aluno aluno = alunoService.findById(idAluno).get();
        BeanUtils.copyProperties(alunoDTO, aluno);
        aluno.setId(idAluno);

        return ResponseEntity.status(HttpStatus.OK).body(alunoService.save(aluno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Long idAluno) {
        if (!alunoService.existsById(idAluno)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum Aluno com o ID informado");
        }
        alunoService.deleteById(idAluno);
        return ResponseEntity.status(HttpStatus.OK).body("Aluno deletado com sucesso!");
    }
}
