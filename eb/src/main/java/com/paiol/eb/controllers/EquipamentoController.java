package com.paiol.eb.controllers;

import com.paiol.eb.models.Equipamento;
import com.paiol.eb.repository.EquipamentoRepository;
import com.paiol.eb.service.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/cadastrar-equipamento")
public class EquipamentoController {

    @Autowired
    private EquipamentoRepository repository;

    private final EquipamentoService service;

    public EquipamentoController(EquipamentoService service) {
        this.service = service;
    }

    @GetMapping
    public String form() {
        return "equipamento/formEquipamento";
    }

    @GetMapping("/equipamentos")
    public ModelAndView buscarTodos() {
        ModelAndView modelAndView = new ModelAndView("equipamento/reserva");
        Iterable<Equipamento> equipamentos = service.findAll();
        modelAndView.addObject("equipamentos", equipamentos);
        return modelAndView;
    }

    @PostMapping
    public String form(Equipamento equipamento) {
        service.save(equipamento);
        return "redirect:/cadastrar-equipamento";
    }

    @GetMapping("/deletar")
    public String deletarEquipamento(Long codigo) {
        Equipamento equipamento = service.findByCodigo(codigo);
        service.delete(equipamento);
        return "redirect:/cadastrar-equipamento/equipamentos";
    }

    @GetMapping("/edit/{codigo}")
    public String editarEquipamento(@PathVariable("codigo") Long codigo, Model model) {
        Equipamento equipamento = service.findByCodigo(codigo);
        model.addAttribute("equipamento", equipamento);
        return "equipamento/editaEquipamento";
    }

    @PostMapping("update/{codigo}")
    public String updateStudent(@PathVariable("codigo") Long codigo, @Valid Equipamento equipamento, Model model) {
        service.save(equipamento);
        model.addAttribute("students", service.findAll());
        return "index";
    }
}
