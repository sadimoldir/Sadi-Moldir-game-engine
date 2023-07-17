package com.game.entities.game.engine.dao;

import com.game.entities.game.engine.data.DataContainer;
import com.game.entities.game.engine.dto.Ability;
import com.game.entities.game.engine.dto.Hero;
import com.game.entities.game.engine.dto.Player;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class PlayerDAO {
    private final JdbcTemplate jdbcTemplate;
    private final HeroDAO heroDAO;
    private final DataContainer dataContainer = new DataContainer();

    @Autowired
    public PlayerDAO(JdbcTemplate jdbcTemplate, HeroDAO heroDAO) {
        this.jdbcTemplate = jdbcTemplate;
        this.heroDAO = heroDAO;
    }

    @PostConstruct
    public void init() {
        createTablePlayers();
        savePlayers(dataContainer.getAllPlayers());
    }

    public void createTablePlayers() {
        jdbcTemplate.update("CREATE TABLE IF NOT EXISTS players (id IDENTITY PRIMARY KEY, name VARCHAR(255), " +
                "nickname VARCHAR(255),teamName VARCHAR(255), hero_id BIGINT, FOREIGN KEY (hero_id) REFERENCES heroes(id))");
    }
    public void savePlayers(List<Player> players) {
        List<Object[]> playersBatchArgs = new ArrayList<>();
        for (Player p : players) {
            for(Hero h:p.getHeroes()) {
                Object[] o = {p.getName(), p.getNickname(), p.getTeamName(), heroDAO.findHeroIdByName(h.getName())};
                playersBatchArgs.add(o);
            }
        }
        jdbcTemplate.batchUpdate("INSERT INTO players (name,nickname,teamName,hero_id) " +
                "VALUES ( ? , ? , ? , ? )", playersBatchArgs);
    }

    public List<Player> findAllPlayers() {
        List<Player> players= jdbcTemplate.query("SELECT id, name, nickname, teamName FROM players",
                (rs, rowNum) -> Player.playerBuilder()
                        .id(rs.getLong("id"))
                        .name(rs.getString("name"))
                        .nickname(rs.getString("nickname"))
                        .teamName(rs.getString("teamName"))
                        .build()
        );
        for (Player player : players) {
            List<Hero> heroes = findPlayerHeroesByName(player.getName());
            player.setHeroes(heroes);
        }
        return players;
    }
   public List<Player> playerInferencePattern(String s,Object o){
        return jdbcTemplate.query("SELECT id, name, nickname, teamName players WHERE "+s+"= ?",
                (rs, rowNum) ->  Player.playerBuilder()
                            .id(rs.getLong("id"))
                            .name(rs.getString("name"))
                            .nickname(rs.getString("nickname"))
                            .teamName(rs.getString("teamName"))
                            .heroes(findPlayerHeroesByName(rs.getString("name")))
                            .build(),o
                );

    }
    public List<Hero> findPlayerHeroesByName(String name) {
        List<Hero> heroes=new ArrayList<>();
        List<Long> heroesId= jdbcTemplate.queryForList("SELECT hero_id FROM players WHERE name = ?", Long.class,name);
        for(Long h:heroesId) {
            Hero hero=heroDAO.findHeroById(h);
            if(hero!=null) {
                heroes.add(hero);
            }
        }
        return heroes;
    }
    public Player findHeroByName(String name) {
        return playerInferencePattern("name", name).stream().findFirst().orElse(null);
    }
    public Player findHeroByNickName(String nickname) {
        return playerInferencePattern("nickname", nickname).stream().findFirst().orElse(null);
    }
    public List<Player> findPlayersByTeamName(String teamName) {
        return playerInferencePattern("team_name", teamName);
    }


}
