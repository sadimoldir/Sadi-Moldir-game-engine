package com.game.entities.game.engine.repositories.Impl;

import com.game.entities.game.engine.data.DataContainer;
import com.game.entities.game.engine.dto.Ability;
import com.game.entities.game.engine.dto.Hero;
import com.game.entities.game.engine.repositories.AbilityRepository;
import com.game.entities.game.engine.repositories.GameEngineRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
@NoArgsConstructor
public class AbilityRepositoryImpl implements GameEngineRepository<Ability>, AbilityRepository {
    private  DataContainer dataContainer= new DataContainer();

    @Override
    public List<Ability> findAll() {
        return dataContainer.getAllAbilities();
    }

    @Override
    public Ability findByName(String name) {
        return findAll().stream().filter(a-> a.getName().equals(name)).findAny().orElse(null);
    }

    @Override
    public List<Ability> findAbilitiesByDamageType(String damageType) {
        return findAll().stream().filter(a -> a.getDamageType().equals(Ability.DamageType.valueOf(damageType)))
                .collect(Collectors.toList());
    }
}
