package com.game.entities.game.engine.data;

import com.game.entities.game.engine.dto.Ability;
import com.game.entities.game.engine.dto.Hero;
import com.game.entities.game.engine.dto.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataContainer  {
    Ability rage = Ability.abilityBuilder()
            .name("RAGE")
            .description("Entering an insane rage" +
                    ", the hero becomes immune to effects and gains +80% magic resistance" +
                    ", and his movement speed increases. ")
            .manaCost(75)
            .coolDown(20)
            .damageType("ABSENT")
            .build();
    Ability feast = Ability.abilityBuilder()
            .name("FEAST")
            .description("Adds additional damage and lifesteal to the hero's attacks" +
                    " based on the enemy's maximum health.")
            .manaCost(0)
            .coolDown(0)
            .damageType("PHYSICAL")
            .build();
    Ability ghoulFrenzy = Ability.abilityBuilder()
            .name("GHOUL FRENZY")
            .description("The hero's attacks significantly slow the enemy's movement for 1.5 seconds. " +
                    "Increases the wearer's attack speed.")
            .manaCost(0)
            .coolDown(0)
            .damageType("PHYSICAL")
            .build();
    Ability infest = Ability.abilityBuilder()
            .name("INFEST")
            .description("The hero climbs into the body of the selected creature," +
                    " becoming invisible to opponents and restoring a fraction of his maximum health every second. " +
                    "After that, it can break out of the carrier, dealing damage to surrounding enemies." +
                    " Being inside an enemy or neutral creep, the hero can fully control it. Does not affect enemy heroes. ")
            .manaCost(100)
            .coolDown(80)
            .damageType("MAGICAL")
            .build();
    Ability waveform = Ability.abilityBuilder()
            .name("WAVEFORM")
            .description("The hero turns into liquid and rushes forward" +
                    ", dealing damage to all enemies in his path. During the duration of the ability" +
                    ", the hero is invulnerable.")
            .manaCost(130)
            .coolDown(21)
            .damageType("MAGICAL")
            .build();
    Ability adaptiveStrikeA = Ability.abilityBuilder()
            .name("ADAPTIVE STRIKE (AGILITY)")
            .description("Launches a stream of water at an enemy creature, dealing damage based on the hero's dexterity." +
                    " The agility multiplier will be maximum if the hero's agility is 50% higher than his strength. " +
                    "Grants a permanent bonus to agility.")
            .manaCost(40)
            .coolDown(10)
            .damageType("MAGICAL")
            .build();
    Ability adaptiveStrikeF = Ability.abilityBuilder()
            .name("ADAPTIVE STRIKE (FORCE)")
            .description("Launches a stream of water at an enemy creature, dealing damage based on the hero's dexterity." +
                    " The agility multiplier will be maximum if the hero's agility is 50% higher than his strength. " +
                    "Grants a permanent bonus to agility. ")
            .manaCost(40)
            .coolDown(10)
            .damageType("MAGICAL")
            .build();
    Ability attributeShiftD = Ability.abilityBuilder()
            .name("ATTRIBUTE SHIFT (DEXTERITY)")
            .description("The hero changes his form, turning points of strength into points of agility. " +
                    "This process is reversible. With the level of the ability, the speed of transformation increases.")
            .manaCost(0)
            .coolDown(0)
            .damageType("ABSENT")
            .build();
    Ability attributeShiftS = Ability.abilityBuilder()
            .name("ATTRIBUTE SHIFT (STRENGTH)")
            .description("The hero changes his form, turning points of agility into points of strength. " +
                    "This process is reversible. With the level of the ability, the speed of transformation increases.")
            .manaCost(0)
            .coolDown(0)
            .damageType("ABSENT")
            .build();
    Ability morph = Ability.abilityBuilder()
            .name("MORPH")
            .description("The hero changes his form in the image and likeness of the selected enemy, gaining his main abilities." +
                    " During the action, the hero's form can be changed to the main one and vice versa.")
            .manaCost(50)
            .coolDown(140)
            .damageType("ABSENT")
            .build();

    Ability bladeFury = Ability.abilityBuilder()
            .name("BLADE FURY")
            .description("The hero spins in a whirlwind of crushing blade strikes," +
                    " becoming immune to effects, gaining +80% magic resistance and dealing damage to nearby enemies.")
            .manaCost(120)
            .coolDown(42)
            .damageType("MAGICAL")
            .build();
    Ability healingWard = Ability.abilityBuilder()
            .name("HEALING WARD")
            .description("Summons a totem that heals all nearby allies and moves at a speed of 325.0. " +
                    "The amount of healing depends on the maximum health of the ally. Lasts 25.0 sec.")
            .manaCost(140)
            .coolDown(60)
            .damageType("ABSENT")
            .build();
    Ability abladeDance = Ability.abilityBuilder()
            .name("ABLADE DANCE")
            .description("Gives the hero a chance to deal critical damage with an attack.")
            .manaCost(0)
            .coolDown(0)
            .damageType("ABSENT")
            .build();
    Ability omnislash = Ability.abilityBuilder()
            .name("OMNISLASH")
            .description("The hero jumps to the target enemy, and then attacks him and nearby enemies with increased speed. " +
                    "For the duration of the ability, the hero becomes invulnerable. ")
            .manaCost(200)
            .coolDown(120)
            .damageType("PHYSICAL")
            .build();
    Ability timeWalk = Ability.abilityBuilder()
            .name("TIME WALK")
            .description("Dash to the target location and restore the health lost in the last 2.0 seconds.")
            .manaCost(40)
            .coolDown(24)
            .damageType("ABSENT")
            .build();
    Ability timeDilation = Ability.abilityBuilder()
            .name("TIME DILATION")
            .description("Places a temporary field on nearby enemies, increasing their ability cooldowns by 8.0 seconds. " +
                    "Each ability hit slows the victim's movement and attack by 10.0% and deals damage every second." +
                    " The duration of this effect is not reduced by Chronosphere.")
            .manaCost(60)
            .coolDown(28)
            .damageType("MAGICAL")
            .build();
    Ability timeLock = Ability.abilityBuilder()
            .name("TIME LOCK")
            .description("The attack can stop time for an enemy creature, causing it to take another hit.")
            .manaCost(0)
            .coolDown(0)
            .damageType("MAGICAL")
            .build();
    Ability chronosphere = Ability.abilityBuilder()
            .name("CHRONOSPHERE")
            .description("Creates a sphere in which space and time freeze. It stops everything inside itself" +
                    ", and its owner and creatures under his control move in it with increased speed. Inside the sphere" +
                    ", the invisibility of enemies is revealed and the cooldowns of all items and abilities are stopped.")
            .manaCost(150)
            .coolDown(160)
            .damageType("ABSENT")
            .build();
    Hero lifestealer = Hero.heroBuilder()
            .name("LIFESTEALER")
            .description("Forces Lifestealer to make instant attacks against the infected enemy in 1.25 second intervals" +
                    ", starting immediately upon cast, resulting in 5 attacks on the target. " +
                    "These instant attacks can trigger attack modifiers and interact normally with attack-based effects.")
            .health(610)
            .mana(255)
            .mainAttribute("STRENGTH")
            .abilities(getLifestealerAbilities())
            .build();

    Hero morphling = Hero.heroBuilder()
            .name("MORPHLING")
            .description("Morphling is a highly adaptive hero in Dota 2, capable of shifting between Strength and Agility " +
                    "attributes to become durable or agile. His ultimate ability, \"Morph,\" allows him to replicate enemy" +
                    "heroes' abilities, granting him versatility and making him a formidable force in battles.")
            .health(626)
            .mana(303)
            .mainAttribute("STRENGTH")
            .abilities(getMorphlingAbilities())
            .build();

    Hero juggernaut = Hero.heroBuilder()
            .name("JUGGERNAUT")
            .description("Juggernaut is a swift and deadly hero in Dota 2, known for his powerful ultimate ability called " +
                    "\"Omnislash,\" which allows him to perform a series of rapid attacks on enemies in his vicinity. " +
                    "With his healing ward and blade fury, Juggernaut can sustain in fights and deal significant damage" +
                    ", making him a formidable carry hero.")
            .health(560)
            .mana(243)
            .mainAttribute("AGGRESSION")
            .abilities(getJuggernautAbilities())
            .build();

    Hero facelessVoid = Hero.heroBuilder()
            .name("FACELESS VOID")
            .description("Faceless Void is a time-controlling hero in Dota 2, capable of trapping enemies in a powerful " +
                    "area-of-effect ultimate called \"Chronosphere,\" where they become immobilized while he and his allies" +
                    " can freely attack within the sphere. His \"Time Walk\" ability allows him to quickly traverse through time" +
                    ", restoring his health to a previous state, making him elusive and difficult to take down.")
            .health(560)
            .mana(255)
            .mainAttribute("STRENGTH")
            .abilities(getFacelessVoidAbilities())
            .build();

    Player yatoro = Player.playerBuilder()
            .name("Ilya")
            .nickname("Yatoro")
            .teamName("Team Spirit")
            .heroes(getYatoroHeroes())
            .build();
    Player dyrachyo = Player.playerBuilder()
            .name("Anton")
            .nickname("Dyrachyo")
            .teamName("Gaimin Gladiators")
            .heroes(getDyrachyoHeroes())
            .build();
    Player suma1l = Player.playerBuilder()
            .name("Sumail")
            .nickname("Suma1l")
            .teamName("Team Aster")
            .heroes(getSuma1lHeroes())
            .build();


    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();
        players.add(yatoro);
        players.add(dyrachyo);
        players.add(suma1l);
        return players;
    }

    public List<Hero> getAllHeroes() {
        List<Hero> heroes = new ArrayList<>();
        heroes.add(lifestealer);
        heroes.add(morphling);
        heroes.add(juggernaut);
        heroes.add(facelessVoid);
        return heroes;
    }

    public List<Ability> getAllAbilities() {
        List<Ability> abilities = new ArrayList<>();
        abilities.add(rage);
        abilities.add(feast);
        abilities.add(ghoulFrenzy);
        abilities.add(infest);
        abilities.add(waveform);
        abilities.add(adaptiveStrikeA);
        abilities.add(adaptiveStrikeF);
        abilities.add(attributeShiftD);
        abilities.add(attributeShiftS);
        abilities.add(morph);
        abilities.add(bladeFury);
        abilities.add(healingWard);
        abilities.add(abladeDance);
        abilities.add(omnislash);
        abilities.add(timeWalk);
        abilities.add(timeDilation);
        abilities.add(timeLock);
        abilities.add(chronosphere);
        return abilities;
    }

    public List<Hero> getYatoroHeroes() {
        List<Hero> heroes = new ArrayList<>();
        heroes.add(morphling);
        heroes.add(juggernaut);
        return heroes;
    }

    public List<Hero> getDyrachyoHeroes() {
        List<Hero> heroes = new ArrayList<>();
        heroes.add(lifestealer);
        heroes.add(morphling);
        return heroes;
    }

    public List<Hero> getSuma1lHeroes() {
        List<Hero> heroes = new ArrayList<>();
        heroes.add(juggernaut);
        heroes.add(facelessVoid);
        return heroes;
    }

    public List<Ability> getLifestealerAbilities() {
        List<Ability> abilities = new ArrayList<>();
        abilities.add(rage);
        abilities.add(feast);
        abilities.add(ghoulFrenzy);
        abilities.add(infest);
        return abilities;
    }

    public List<Ability> getMorphlingAbilities() {
        List<Ability> abilities = new ArrayList<>();
        abilities.add(waveform);
        abilities.add(adaptiveStrikeA);
        abilities.add(adaptiveStrikeF);
        abilities.add(attributeShiftD);
        abilities.add(attributeShiftS);
        abilities.add(morph);
        return abilities;
    }

    public List<Ability> getJuggernautAbilities() {
        List<Ability> abilities = new ArrayList<>();
        abilities.add(bladeFury);
        abilities.add(healingWard);
        abilities.add(abladeDance);
        abilities.add(omnislash);
        return abilities;
    }

    public List<Ability> getFacelessVoidAbilities() {
        List<Ability> abilities = new ArrayList<>();
        abilities.add(timeWalk);
        abilities.add(timeDilation);
        abilities.add(timeLock);
        abilities.add(chronosphere);
        return abilities;
    }
}



