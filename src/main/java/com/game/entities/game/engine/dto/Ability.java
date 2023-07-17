package com.game.entities.game.engine.dto;

import lombok.Data;

@Data
public class Ability {
    private Long id;
    private String name;
    private String description;
    private int manaCost;
    private int coolDown;
    public enum DamageType {PHYSICAL, MAGICAL, PURE}
    private DamageType damageType;


    public static AbilityBuilder abilityBuilder() {
        return new Ability().new AbilityBuilder();
    }

    public class AbilityBuilder {
        public AbilityBuilder id(long id) {
            Ability.this.id = id;
            return this;
        }

        public AbilityBuilder name(String name) {
            Ability.this.name = name;
            return this;
        }

        public AbilityBuilder description(String description) {
            Ability.this.description = description;
            return this;
        }

        public AbilityBuilder manaCost(int manaCost) {
            Ability.this.manaCost = manaCost;
            return this;
        }

        public AbilityBuilder coolDown(int coolDown) {
            Ability.this.coolDown = coolDown;
            return this;
        }

        public AbilityBuilder damageType(String damageType) {
            Ability.this.damageType = Ability.DamageType.valueOf(damageType);
            return this;
        }

        public Ability build() {
            return Ability.this;
        }

    }


}
