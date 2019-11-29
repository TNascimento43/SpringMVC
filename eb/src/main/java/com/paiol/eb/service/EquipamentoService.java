package com.paiol.eb.service;

import com.paiol.eb.models.Equipamento;

public interface EquipamentoService {
    Iterable<Equipamento> findAll();

    Equipamento findByCodigo(Long codigo);

    void save(Equipamento equipamento);

    void delete(Equipamento equipamento);
}
