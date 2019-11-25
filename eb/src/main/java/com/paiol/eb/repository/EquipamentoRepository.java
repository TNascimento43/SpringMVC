package com.paiol.eb.repository;

import com.paiol.eb.models.Equipamento;
import org.springframework.data.repository.CrudRepository;

public interface EquipamentoRepository extends CrudRepository<Equipamento, String> {
    Equipamento findByCodigo(Long codigo);
}
