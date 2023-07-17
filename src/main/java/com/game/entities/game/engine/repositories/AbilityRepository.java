package com.game.entities.game.engine.repositories;
import com.game.entities.game.engine.dto.Ability;
import com.game.entities.game.engine.dto.Hero;

import java.util.List;

public interface AbilityRepository {
    public List<Ability> findAbilitiesByDamageType(String damageType);



}
