package com.game.entities.game.engine.services;
import com.game.entities.game.engine.dto.Ability;
import com.game.entities.game.engine.dto.Hero;
import com.game.entities.game.engine.dto.Player;

import java.util.List;

public interface GameEngineService {

    public List<Player> getAllPlayers();
    public Player getPlayerByName(String name);
    public Player getPlayerByNickname(String nickname);
    public List<Player> getPlayersByTeamName(String teamName);
    public List<Hero> getMainHeroesByPlayerName(String name);

    public List<Hero> getAllHeroes();
    public Hero getHeroByName(String name);

    public List<Hero> getHeroesByMainAttribute(String mainAttribute);
    public List<Ability> getAbilitiesByHeroName(String name);
    public List<Ability> getAllAbilities();
    public Ability getAbilityByName(String name);
    public List<Ability> getAbilitiesByDamageType(String damageType);


}
