package com.game.entities.game.engine.repositories.Impl;
import com.game.entities.game.engine.dao.HeroDAO;
import com.game.entities.game.engine.dto.Ability;
import com.game.entities.game.engine.dto.Hero;
import com.game.entities.game.engine.repositories.GameEngineRepository;
import com.game.entities.game.engine.repositories.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.stream.Collectors;

@Repository

public class HeroRepositoryImpl implements GameEngineRepository<Hero>,HeroRepository {
    private final HeroDAO heroDAO;
    @Autowired
    public HeroRepositoryImpl(HeroDAO heroDAO) {
        this.heroDAO = heroDAO;
    }

    @Override
    public List<Hero> findAll() {
        return heroDAO.findAllHeroes();
    }

    @Override
    public Hero findByName(String name) {
        return heroDAO.findHeroByName(name);
    }

    @Override
    public List<Hero> findHeroesByMainAttribute(String mainAttribute) {
        return heroDAO.findHeroesByMainAttribute(mainAttribute);
    }

    @Override
    public List<Ability> findAbilitiesByHeroName(String name) {
        return findByName(name).getAbilities();
    }
}
