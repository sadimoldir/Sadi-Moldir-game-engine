package com.game.entities.game.engine.dao;

import com.game.entities.game.engine.data.DataContainer;
import com.game.entities.game.engine.dto.Ability;
import com.game.entities.game.engine.dto.Hero;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class HeroDAO {
    private final JdbcTemplate jdbcTemplate;
    private final AbilityDAO abilityDAO;
    private final DataContainer dataContainer = new DataContainer();

    @Autowired
    public HeroDAO(JdbcTemplate jdbcTemplate, AbilityDAO abilityDAO) {
        this.jdbcTemplate = jdbcTemplate;
        this.abilityDAO = abilityDAO;
    }

    @PostConstruct
    public void init() {
        createTableHeroes();
        saveHeroes(dataContainer.getAllHeroes());
    }
    public void createTableHeroes() {
        jdbcTemplate.update("CREATE TABLE IF NOT EXISTS heroes (id IDENTITY PRIMARY KEY, name VARCHAR(255), " +
                "description VARCHAR(4000), health INT, mana INT," +
                "main_attribute VARCHAR(255), ability_id BIGINT, FOREIGN KEY (ability_id) REFERENCES abilities(id))");
    }

    public void saveHeroes(List<Hero> heroes) {
        List<Object[]> heroesBatchArgs = new ArrayList<>();
        for (Hero h : heroes) {
            for(Ability a: h.getAbilities()) {
                Object[] o = {h.getName(),h.getDescription(),h.getHealth(),h.getMana(),
                h.getMainAttribute().toString(),abilityDAO.findAbilityIdByName(a.getName())};
                heroesBatchArgs.add(o);
            }
        }
        jdbcTemplate.batchUpdate("INSERT INTO heroes (name,description,health,mana,main_attribute,ability_id) " +
                "VALUES ( ? , ? , ? , ? , ? , ? )", heroesBatchArgs);
    }

    public List<Hero> findAllHeroes() {
         List<Hero> heroes= jdbcTemplate.query("SELECT id, name, description, health, mana, main_attribute, ability_id FROM heroes",
                (rs, rowNum) -> Hero.heroBuilder()
                        .id(rs.getLong("id"))
                        .name(rs.getString("name"))
                        .description(rs.getString("description"))
                        .health(rs.getInt("health"))
                        .mana(rs.getInt("mana"))
                        .mainAttribute(rs.getString("main_attribute"))
                        .build()
        );
        for (Hero hero : heroes) {
            List<Ability> abilities = findHeroAbilitiesByName(hero.getName());
            hero.setAbilities(abilities);
        }
        return heroes;
    }
    public List<Ability> findHeroAbilitiesByName(String name) {
        List<Ability> abilities=new ArrayList<>();
        List<Long> abilitiesId= jdbcTemplate.queryForList("SELECT ability_id FROM heroes WHERE name = ?", Long.class,name);
        for(Long a:abilitiesId) {
            Ability ability= abilityDAO.findAbilityById(a);
            if(ability!=null) {
                abilities.add(ability);
            }
        }
        return abilities;
    }
    public List<Hero> heroInferencePattern(String s, Object o){
        return jdbcTemplate.query("SELECT id, name, description, health, mana, main_attribute FROM heroes WHERE " + s + " = ?"
                ,(rs, rowNum) ->  Hero.heroBuilder()
                        .id(rs.getLong("id"))
                        .name(rs.getString("name"))
                        .description(rs.getString("description"))
                        .health(rs.getInt("health"))
                        .mana(rs.getInt("mana"))
                        .mainAttribute(rs.getString("main_attribute"))
                        .abilities(findHeroAbilitiesByName(rs.getString("name")))
                        .build(),o
        );
    }
    public Hero findHeroById(Long id) {
        return heroInferencePattern("id",id).stream().findFirst().orElse(null);
    }
    public Hero findHeroByName(String name) {
        return heroInferencePattern("name",name).stream().findFirst().orElse(null);
    }
    public List<Hero> findHeroesByMainAttribute(String mainAttribute) {
        return heroInferencePattern("main_attribute",mainAttribute);
    }
    public Long findHeroIdByName(String name) {
        Hero hero= findHeroByName(name);
        return hero.getId();
    }


}
