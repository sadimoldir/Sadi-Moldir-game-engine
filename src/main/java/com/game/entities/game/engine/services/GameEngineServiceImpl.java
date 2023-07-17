package com.game.entities.game.engine.services;

import com.game.entities.game.engine.dto.Ability;
import com.game.entities.game.engine.dto.Hero;
import com.game.entities.game.engine.dto.Player;
import com.game.entities.game.engine.repositories.Impl.AbilityRepositoryImpl;
import com.game.entities.game.engine.repositories.Impl.HeroRepositoryImpl;
import com.game.entities.game.engine.repositories.Impl.PlayerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameEngineServiceImpl implements GameEngineService {

    private final AbilityRepositoryImpl abilityRepository;
    private final HeroRepositoryImpl heroRepository;
    private final PlayerRepositoryImpl playerRepository;

    @Autowired
    public GameEngineServiceImpl(AbilityRepositoryImpl abilityRepository, HeroRepositoryImpl heroRepository, PlayerRepositoryImpl playerRepository) {
        this.abilityRepository = abilityRepository;
        this.heroRepository = heroRepository;
        this.playerRepository = playerRepository;
    }
    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }
    @Override
    public Player getPlayerByName(String name) {
        return playerRepository.findByName(name);
    }
    @Override
    public List<Player> getPlayersByTeamName(String teamName) {
        return playerRepository.findPlayersByTeamName(teamName);
    }
    @Override
    public Player getPlayerByNickname(String nickname) {
        return playerRepository.findPlayerByNickname(nickname);
    }

    @Override
    public List<Hero> getAllHeroes() {
        return heroRepository.findAll();
    }

    @Override
    public Hero getHeroByName(String name) {
        return heroRepository.findByName(name);
    }
    @Override
    public List<Hero> getHeroesByMainAttribute(String mainAttribute) {
        return heroRepository.findHeroesByMainAttribute(mainAttribute);
    }

    @Override
    public List<Ability> getAllAbilities() {
        return abilityRepository.findAll();
    }

    @Override
    public Ability getAbilityByName(String name) {
        return abilityRepository.findByName(name);
    }
    @Override
    public List<Ability> getAbilitiesByDamageType(String damageType) {
        return abilityRepository.findAbilitiesByDamageType(damageType);
    }
    @Override
    public List<Ability> getAbilitiesByHeroName(String name) {
        return heroRepository.findAbilitiesByHeroName(name);
    }

    @Override
    public List<Hero> getMainHeroesByPlayerName(String name) {
        return playerRepository.findMainHeroesByPlayerName(name);
    }
}
