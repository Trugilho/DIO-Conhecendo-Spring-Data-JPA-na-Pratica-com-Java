package java.controller;

import java.entity.Aluno;
import java.entity.AvaliacaoFisica;
import java.entity.form.AlunoForm;
import java.entity.form.AlunoUpdateForm;
import java.service.impl.AlunoServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

  @Autowired
  private AlunoServiceImpl service;

  @PostMapping
  public Aluno create(@Valid @RequestBody AlunoForm form) {
    return service.create(form);
  }

  @GetMapping("/avaliacoes/{id}")
  public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable Long id) {
    return service.getAllAvaliacaoFisicaId(id);
  }

  @GetMapping
  public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false) String dataDeNacimento) {
    return service.getAll(dataDeNacimento);
  }

  @GetMapping("/{id}")
  public Aluno get(@PathVariable Long id) {
    return service.get(id);
  }

  @PutMapping("/{id}")
  public Aluno update(@PathVariable Long id, @Valid @RequestBody AlunoUpdateForm formUpdate) {
    return service.update(id, formUpdate);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    service.delete(id);
  }

}
