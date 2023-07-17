package com.game.entities.game.engine.repositories.Impl;
import com.game.entities.game.engine.data.DataContainer;
import com.game.entities.game.engine.dto.Ability;
import com.game.entities.game.engine.dto.Hero;
import com.game.entities.game.engine.dto.Player;
import com.game.entities.game.engine.repositories.GameEngineRepository;
import com.game.entities.game.engine.repositories.HeroRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
@NoArgsConstructor
public class HeroRepositoryImpl implements GameEngineRepository<Hero>,HeroRepository {
    private  DataContainer dataContainer= new DataContainer();

    @Override
    public List<Hero> findAll() {
        return dataContainer.getAllHeroes();
    }

    @Override
    public Hero findByName(String name) {
        return findAll().stream().filter(h-> h.getName().equals(name)).findAny().orElse(null);
    }

    @Override
    public List<Hero> findHeroesByMainAttribute(String mainAttribute) {
        return findAll().stream().filter(h-> h.getMainAttribute().equals(Hero.MainAttribute.valueOf(mainAttribute)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Ability> findAbilitiesByHeroName(String name) {
        return findByName(name).getAbilities();
    }
}
