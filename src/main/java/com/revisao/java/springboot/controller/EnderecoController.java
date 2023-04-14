package com.revisao.java.springboot.controller;

import com.revisao.java.springboot.model.dto.EnderecoDTO;
import com.revisao.java.springboot.model.entity.Endereco;
import com.revisao.java.springboot.service.EnderecoService;
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
@RequestMapping("/endereco")
public class EnderecoController {
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<Endereco>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(name = "id") Long idEndereco) {
        if (!enderecoService.existsById(idEndereco)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum Endereco com o ID informado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.findById(idEndereco));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid EnderecoDTO enderecoDTO) {
        Endereco endereco = new Endereco();
        BeanUtils.copyProperties(enderecoDTO, endereco);
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.save(endereco));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> edit(@RequestBody @Valid EnderecoDTO enderecoDTO, @PathVariable(name = "id") Long idEndereco) {
        if (!enderecoService.existsById(idEndereco)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum Endereco com o ID informado");
        }

        Endereco endereco = enderecoService.findById(idEndereco).get();
        BeanUtils.copyProperties(enderecoDTO, endereco);
        endereco.setId(idEndereco);

        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.save(endereco));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Long idEndereco) {
        if (!enderecoService.existsById(idEndereco)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum Endereco com o ID informado");
        }
        enderecoService.deleteById(idEndereco);
        return ResponseEntity.status(HttpStatus.OK).body("Endereco deletado com sucesso!");
    }
}
