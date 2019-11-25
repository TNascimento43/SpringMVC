package com.paiol.eb.controllers;

import com.paiol.eb.models.Equipamento;
import com.paiol.eb.repository.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cadastrar-equipamento")
public class EquipamentoController {

    @Autowired
    private EquipamentoRepository repository;

    @GetMapping
    public String form() {
        return "equipamento/formEquipamento";
    }

    @GetMapping("/equipamentos")
    public ModelAndView buscarTodos() {
        ModelAndView modelAndView = new ModelAndView("equipamento/reserva");
        Iterable<Equipamento> equipamentos = repository.findAll();
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

    @GetMapping("/alterar")
    public String atualizarEquipamento(Long codigo) {
        Equipamento equipamento = repository.findByCodigo(codigo);
        repository.delete(equipamento);
        ModelAndView modelAndView = new ModelAndView("equipamento/editarEquipamento");
        modelAndView.addObject("equipamento", equipamento);
        repository.save(equipamento);
        return "redirect:/cadastrar-equipamento";

//        return modelAndView;
    }
}
