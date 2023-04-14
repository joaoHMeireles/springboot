package com.revisao.java.springboot.controller;

import com.revisao.java.springboot.model.dto.CursoDTO;
import com.revisao.java.springboot.model.entity.Curso;
import com.revisao.java.springboot.service.CursoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@AllArgsConstructor
@Controller
@RequestMapping("/curso")
public class CursoController {
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(name = "id") Long idCurso) {
        if (!cursoService.existsById(idCurso)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum Curso com o ID informado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.findById(idCurso));
    }

    @Transactional
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid CursoDTO cursoDTO) {
        Curso curso = new Curso();
        BeanUtils.copyProperties(cursoDTO, curso);
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.save(curso));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> edit(@RequestBody @Valid CursoDTO cursoDTO, @PathVariable(name = "id") Long idCurso) {
        if (!cursoService.existsById(idCurso)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum Curso com o ID informado");
        }

        Curso curso = cursoService.findById(idCurso).get();
        BeanUtils.copyProperties(cursoDTO, curso);
        curso.setId(idCurso);

        return ResponseEntity.status(HttpStatus.OK).body(cursoService.save(curso));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Long idCurso) {
        if (!cursoService.existsById(idCurso)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum Curso com o ID informado");
        }
        cursoService.deleteById(idCurso);
        return ResponseEntity.status(HttpStatus.OK).body("Curso deletado com sucesso!");
    }
}
