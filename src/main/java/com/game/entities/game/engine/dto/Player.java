package com.game.entities.game.engine.dto;

import lombok.Data;

import java.util.List;

@Data
public class Player {
    private long id;
    private String name;
    private String nickname;
    private String teamName;
    private List<Hero> heroes;

    public static PlayerBuilder playerBuilder(){ return new Player().new PlayerBuilder();}
    public class PlayerBuilder{
        public PlayerBuilder id(Long id) {
            Player.this.id = id;
            return this;
        }
        public PlayerBuilder name(String name) {
            Player.this.name = name;
            return this;
        }
        public PlayerBuilder nickname(String nickname) {
            Player.this.nickname = nickname;
            return this;
        }
        public PlayerBuilder teamName(String teamName) {
            Player.this.teamName = teamName;
            return this;
        }
        public PlayerBuilder heroes(List<Hero> heroes) {
            Player.this.heroes=heroes;
            return this;
        }
        public Player build() {
            return Player.this;
        }
    }


}
