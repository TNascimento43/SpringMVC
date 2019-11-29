package com.paiol.eb.service.impl;

import com.paiol.eb.models.Equipamento;
import com.paiol.eb.repository.EquipamentoRepository;
import com.paiol.eb.service.EquipamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceImpl implements EquipamentoService {

    private final EquipamentoRepository repository;

    public ServiceImpl(EquipamentoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Equipamento> findAll() {
        return repository.findAll();
    }

    @Override
    public Equipamento findByCodigo(Long codigo) {
        return repository.findByCodigo(codigo);
    }
}
