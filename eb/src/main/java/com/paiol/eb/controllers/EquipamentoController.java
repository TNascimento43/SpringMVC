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
        repository.save(equipamento);
        return "redirect:/cadastrar-equipamento";
    }

    @GetMapping("/deletar")
    public String deletarEquipamento(Long codigo) {
        Equipamento equipamento = repository.findByCodigo(codigo);
        repository.delete(equipamento);
        return "redirect:/cadastrar-equipamento/equipamentos";
    }

//    @RequestMapping("/edit")
//    public ModelAndView editarEquipamento(@RequestParam Long codigo) {
//        ModelAndView modelAndView = new ModelAndView("equipamento/editaEquipamento");
//        Equipamento equipamento = service.findByCodigo(codigo);
//        modelAndView.addObject("equipamento", equipamento);
//        return modelAndView;
//    }
    @GetMapping("/edit/{codigo}")
    public String editarEquipamento(@PathVariable("codigo") Long codigo, Model model) {
//        ModelAndView modelAndView = new ModelAndView("equipamento/editaEquipamento");
        Equipamento equipamento = repository.findByCodigo(codigo);
        model.addAttribute("equipamento", equipamento);
        return "equipamento/editaEquipamento";
    }
    @PostMapping("update/{codigo}")
    public String updateStudent(@PathVariable("codigo") Long codigo, @Valid Equipamento equipamento, Model model) {
//        if (result.hasErrors()) {
//            student.setId(id);
//            return "update-student";
//        }
        repository.save(equipamento);
        model.addAttribute("students", repository.findAll());
        return "index";
    }
}
