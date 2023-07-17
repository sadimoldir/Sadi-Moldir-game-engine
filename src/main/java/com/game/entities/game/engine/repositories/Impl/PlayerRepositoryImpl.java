package com.game.entities.game.engine.repositories.Impl;

import com.game.entities.game.engine.data.DataContainer;
import com.game.entities.game.engine.dto.Hero;
import com.game.entities.game.engine.dto.Player;
import com.game.entities.game.engine.repositories.GameEngineRepository;
import com.game.entities.game.engine.repositories.PlayerRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
@NoArgsConstructor
public class PlayerRepositoryImpl implements GameEngineRepository<Player>, PlayerRepository {
    private DataContainer dataContainer= new DataContainer();
    @Override
    public List<Player> findAll() {
        return dataContainer.getAllPlayers();
    }
    @Override
    public Player findByName(String name) {
        return findAll().stream().filter(p->p.getName().equals(name)).findAny().orElse(null);
    }

    @Override
    public List<Player> findPlayersByTeamName(String teamName) {
        return findAll().stream().filter(p->p.getTeamName().equals(teamName)).collect(Collectors.toList());
    }

    @Override
    public Player findPlayerByNickname(String nickname) {
        return findAll().stream().filter(p->p.getNickname().equals(nickname)).findAny().orElse(null);
    }

    @Override
    public List<Hero> findMainHeroesByPlayerName(String name) {
        return findByName(name).getHeroes();
    }
}
