package com.game.entities.game.engine.repositories;
import com.game.entities.game.engine.dto.Ability;
import com.game.entities.game.engine.dto.Hero;
import com.game.entities.game.engine.dto.Player;

import java.util.List;

public interface HeroRepository {
    public List<Hero> findHeroesByMainAttribute(String mainAttribute);
    public List<Ability> findAbilitiesByHeroName(String name);
}
