package com.revisao.java.springboot.controller;

import com.revisao.java.springboot.model.dto.EscolaDTO;
import com.revisao.java.springboot.model.entity.Curso;
import com.revisao.java.springboot.model.entity.Escola;
import com.revisao.java.springboot.model.entity.Professor;
import com.revisao.java.springboot.service.CursoService;
import com.revisao.java.springboot.service.EscolaService;
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
@RequestMapping("/escola")
public class EscolaController {

    private EscolaService escolaService;
    private ProfessorService professorService;
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Escola>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(escolaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(name = "id") Long idEscola) {
        if (!escolaService.existsById(idEscola)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhuma Escola com o ID informado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(escolaService.findById(idEscola));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid EscolaDTO escolaDTO) {
        Escola escola = new Escola();
        BeanUtils.copyProperties(escolaDTO, escola);

        Escola escolaSalva = escolaService.save(escola);

        for(Professor professor : escolaDTO.getListaDeProfessores()){
            for(Professor professorDataBase : professorService.findAll()){
                if(professorDataBase.getEmail().equals(professor.getEmail())){
                    professor.setEscola(escolaSalva);
                    professorService.save(professor);
                }
            }
        }

        for(Curso curso : escolaDTO.getListaDeCursos()){
            for(Curso cursoDataBase : cursoService.findAll()){
                if(cursoDataBase.getNome().equals(curso.getNome())){
                    curso.setEscola(escolaSalva);
                    cursoService.save(curso);
                }
            }
        }

        return ResponseEntity.status(HttpStatus.OK).body(escolaSalva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> edit(@RequestBody @Valid EscolaDTO escolaDTO, @PathVariable(name = "id") Long idEscola) {
        if (!escolaService.existsById(idEscola)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhuma Escola com o ID informado");
        }

        Escola escola = escolaService.findById(idEscola).get();
        BeanUtils.copyProperties(escolaDTO, escola);
        escola.setId(idEscola);

        return ResponseEntity.status(HttpStatus.OK).body(escolaService.save(escola));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Long idEscola) {
        if (!escolaService.existsById(idEscola)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhuma Escola com o ID informado");
        }
        escolaService.deleteById(idEscola);
        return ResponseEntity.status(HttpStatus.OK).body("Escola deletada com sucesso!");
    }
}
