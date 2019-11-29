package com.paiol.eb.service.impl;

import com.paiol.eb.models.Equipamento;
import com.paiol.eb.repository.EquipamentoRepository;
import com.paiol.eb.service.EquipamentoService;
import org.springframework.stereotype.Service;

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

    @Override
    public void save(Equipamento equipamento) {
        repository.save(equipamento);
    }

    @Override
    public void delete(Equipamento equipamento) {
        repository.delete(equipamento);
    }
}
