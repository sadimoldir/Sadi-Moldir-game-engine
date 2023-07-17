package com.game.entities.game.engine.dao;

import com.game.entities.game.engine.data.DataContainer;
import com.game.entities.game.engine.dto.Ability;
import com.game.entities.game.engine.dto.Hero;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class AbilityDAO {
    private final JdbcTemplate jdbcTemplate;
    private final DataContainer dataContainer = new DataContainer();

    @Autowired
    public AbilityDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void init() {
        createTableAbilities();
        saveAbilities(dataContainer.getAllAbilities());
    }

    public void createTableAbilities() {
        jdbcTemplate.update("CREATE TABLE IF NOT EXISTS abilities (id IDENTITY PRIMARY KEY," +
                "name VARCHAR(255), description VARCHAR(4000), mana_cost INT,cool_down INT ," +
                "damage_type VARCHAR(255))");
    }

    public void saveAbilities(List<Ability> abilities) {
        List<Object[]> abilitiesBatchArgs = new ArrayList<>();
        for (Ability a : abilities) {
            Object[] o = {a.getName(), a.getDescription(), a.getManaCost(), a.getCoolDown(), a.getDamageType().toString()};
            abilitiesBatchArgs.add(o);
        }
        jdbcTemplate.batchUpdate("INSERT INTO abilities (name,description,mana_cost,cool_down,damage_type) "  +
                "VALUES (?, ?, ?, ?, ?)", abilitiesBatchArgs);
    }

    public List<Ability> findAllAbilities() {
        return jdbcTemplate.query("SELECT id,name,description,mana_cost,cool_down,damage_type FROM abilities",
                (rs, rowNum) -> Ability.abilityBuilder()
                        .id(rs.getLong("id"))
                        .name(rs.getString("name"))
                        .description(rs.getString("description"))
                        .manaCost(rs.getInt("mana_cost"))
                        .coolDown(rs.getInt("cool_down"))
                        .damageType(rs.getString("damage_type"))
                        .build()
        );
    }
    public List<Ability> abilityInferencePattern(String s,Object o){
        return jdbcTemplate.query("SELECT id, name, description, mana_cost, cool_down, damage_type FROM abilities WHERE " + s + " = ?"
                , (rs, rowNum) -> Ability.abilityBuilder()
                        .id(rs.getLong("id"))
                        .name(rs.getString("name"))
                        .description(rs.getString("description"))
                        .manaCost(rs.getInt("mana_cost"))
                        .coolDown(rs.getInt("cool_down"))
                        .damageType(rs.getString("damage_type"))
                        .build(),o);
    }

    public Ability findAbilityById(Long id) {
        return abilityInferencePattern("id",id).stream().findFirst().orElse(null);
    }
    public Ability findAbilityByName(String name) {
        return abilityInferencePattern("name",name).stream().findFirst().orElse(null);
    }
    public List<Ability> findAbilitiesByDamageType(String damageType){
        return abilityInferencePattern("damage_type",damageType);
    }
    public Long findAbilityIdByName(String name) {
        Ability ability=findAbilityByName(name);
        return ability.getId();
    }


}


