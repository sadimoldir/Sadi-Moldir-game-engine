package com.game.entities.game.engine.repositories.Impl;

import com.game.entities.game.engine.dao.PlayerDAO;
import com.game.entities.game.engine.dto.Hero;
import com.game.entities.game.engine.dto.Player;
import com.game.entities.game.engine.repositories.GameEngineRepository;
import com.game.entities.game.engine.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PlayerRepositoryImpl implements GameEngineRepository<Player>, PlayerRepository {
    private final PlayerDAO playerDAO;

    @Autowired
    public PlayerRepositoryImpl(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    @Override
    public List<Player> findAll() {
        return playerDAO.findAllPlayers();
    }

    @Override
    public Player findByName(String name) {
        return playerDAO.findHeroByName(name);}

    @Override
    public List<Player> findPlayersByTeamName(String teamName) {
        return playerDAO.findPlayersByTeamName(teamName);
    }

    @Override
    public Player findPlayerByNickname(String nickname) {
        return  playerDAO.findHeroByNickName(nickname);
    }

    @Override
    public List<Hero> findMainHeroesByPlayerName(String name) {
        return findByName(name).getHeroes();
    }
}
