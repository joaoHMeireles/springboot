package com.revisao.java.springboot.controller;

import com.revisao.java.springboot.model.dto.TurmaDTO;
import com.revisao.java.springboot.model.entity.Turma;
import com.revisao.java.springboot.service.TurmaService;
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
@RequestMapping("/turma")
public class TurmaController {
    private TurmaService turmaService;

    @GetMapping
    public ResponseEntity<List<Turma>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(turmaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(name = "id") Long idTurma) {
        if (!turmaService.existsById(idTurma)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhuma Turma com o ID informado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(turmaService.findById(idTurma));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid TurmaDTO turmaDTO) {
        Turma turma = new Turma();
        BeanUtils.copyProperties(turmaDTO, turma);
        return ResponseEntity.status(HttpStatus.OK).body(turmaService.save(turma));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> edit(@RequestBody @Valid TurmaDTO turmaDTO, @PathVariable(name = "id") Long idTurma) {
        if (!turmaService.existsById(idTurma)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhuma Turma com o ID informado");
        }

        Turma turma = turmaService.findById(idTurma).get();
        BeanUtils.copyProperties(turmaDTO, turma);
        turma.setId(idTurma);

        return ResponseEntity.status(HttpStatus.OK).body(turmaService.save(turma));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Long idTurma) {
        if (!turmaService.existsById(idTurma)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhuma Turma com o ID informado");
        }
        turmaService.deleteById(idTurma);
        return ResponseEntity.status(HttpStatus.OK).body("Turma deletado com sucesso!");
    }
}
