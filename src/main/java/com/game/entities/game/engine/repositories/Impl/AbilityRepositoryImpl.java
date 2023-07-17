package com.game.entities.game.engine.repositories.Impl;

import com.game.entities.game.engine.dao.AbilityDAO;
import com.game.entities.game.engine.dto.Ability;
import com.game.entities.game.engine.repositories.AbilityRepository;
import com.game.entities.game.engine.repositories.GameEngineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AbilityRepositoryImpl implements GameEngineRepository<Ability>, AbilityRepository {
    private final AbilityDAO abilityDAO;

    @Autowired
    public AbilityRepositoryImpl(AbilityDAO abilityDAO) {
        this.abilityDAO = abilityDAO;
    }

    @Override
    public List<Ability> findAll() {
        return abilityDAO.findAllAbilities();
    }

    @Override
    public Ability findByName(String name) {
        return abilityDAO.findAbilityByName(name);
    }

    @Override
    public List<Ability> findAbilitiesByDamageType(String damageType) {
        return abilityDAO.findAbilitiesByDamageType(damageType);
    }
}
