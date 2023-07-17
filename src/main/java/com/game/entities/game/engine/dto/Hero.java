package com.game.entities.game.engine.dto;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Hero {
    private Long id;
    private String name;
    private String description;
    private int health;
    private int mana;
    public enum MainAttribute {STRENGTH, AGGRESSION, INTELLIGENCE, UNIVERSAL}
    private MainAttribute mainAttribute;
    private List<Ability> abilities ;
    public static HeroBuilder heroBuilder() {
        return new Hero().new HeroBuilder();
    }

    public class HeroBuilder {
        public HeroBuilder id(Long id) {
            Hero.this.id = id;
            return this;
        }

        public HeroBuilder name(String name) {
            Hero.this.name = name;
            return this;
        }

        public HeroBuilder description(String description) {
            Hero.this.description = description;
            return this;
        }

        public HeroBuilder health(int health) {
            Hero.this.health = health;
            return this;
        }

        public HeroBuilder mana(int mana) {
            Hero.this.mana = mana;
            return this;
        }

        public HeroBuilder mainAttribute(String mainAttribute) {
            Hero.this.mainAttribute = Hero.MainAttribute.valueOf(mainAttribute);
            return this;
        }

       public HeroBuilder abilities(List<Ability> abilities ) {
            Hero.this.abilities=abilities;
            return this;
        }

        public Hero build() {
            return Hero.this;
        }

    }


}
