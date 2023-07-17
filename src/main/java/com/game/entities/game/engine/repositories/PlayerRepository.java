package com.game.entities.game.engine.repositories;
import com.game.entities.game.engine.dto.Hero;
import com.game.entities.game.engine.dto.Player;
import java.util.List;

public interface PlayerRepository {
    public Player findPlayerByNickname(String nickname);
    public List<Player> findPlayersByTeamName(String teamName);
    public List<Hero> findMainHeroesByPlayerName(String name);

}
