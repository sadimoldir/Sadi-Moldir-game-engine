package com.game.entities.game.engine;

import com.game.entities.game.engine.services.GameEngineServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Scanner;

@EnableAspectJAutoProxy
@SpringBootApplication
public class GameEngineApplication {

    private static final Scanner src = new Scanner(System.in);
    private static GameEngineServiceImpl gameEngineServiceImpl;
    static int temp;
    static String tempS;

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(GameEngineApplication.class, args);
        gameEngineServiceImpl = context.getBean(GameEngineServiceImpl.class);
        while (true) {
            System.out.println("You want to get a list of:\n" +
                    "1.Players 2.Heroes 3.Abilities ");
            temp = src.nextInt();
            System.out.println(gameEngineServiceImpl.getAllPlayers());
            switch (temp) {
                case 1:
                    getPlayers();
                    break;
                case 2:
                    getHeroes();
                    break;
                case 3:
                    getAbilities();
                    break;
            }
        }
    }

    public static void getPlayers() {
        System.out.println("You want to get :\n" +
                "1.All players 2.Player by name 3.Player by nickname " +
                "4.Players by team name 5.This player's main heroes by name");
        temp = src.nextInt();
        switch (temp) {
            case 1:
                System.out.println(gameEngineServiceImpl.getAllPlayers());
                break;
            case 2:
                System.out.println("Enter the name of the player:");
                src.nextLine();
                String tempS = src.nextLine();
                System.out.println(gameEngineServiceImpl.getPlayerByName(tempS));
                break;
            case 3:
                System.out.println("Enter the nickname of the player:");
                src.nextLine();
                tempS = src.nextLine();
                System.out.println(gameEngineServiceImpl.getPlayerByNickname(tempS));
                break;
            case 4:
                System.out.println("Enter the team name of the player:");
                src.nextLine();
                tempS = src.nextLine();
                System.out.println(gameEngineServiceImpl.getPlayersByTeamName(tempS));
                break;
            case 5:
                System.out.println("Enter the name of the player:");
                src.nextLine();
                tempS = src.nextLine();
                System.out.println(gameEngineServiceImpl.getMainHeroesByPlayerName(tempS));
                break;

        }
    }

    public static void getHeroes() {
        System.out.println("You want to get :\n" +
                "1.All heroes 2.Hero by name 3.Heroes by by main attribute " +
                "4.The abilities of this hero by name");
        temp = src.nextInt();
        switch (temp) {
            case 1 -> System.out.println(gameEngineServiceImpl.getAllHeroes());
            case 2 -> {
                System.out.println("Enter the name of the hero:");
                src.nextLine();
                tempS = src.nextLine();
                System.out.println(gameEngineServiceImpl.getHeroByName(tempS));
            }
            case 3 -> {
                System.out.println("Enter the main attribute of the heroes (STRENGTH, AGGRESSION, INTELLIGENCE, UNIVERSAL):");
                src.nextLine();
                tempS = src.nextLine();
                System.out.println(gameEngineServiceImpl.getHeroesByMainAttribute(tempS));
            }
            case 4 -> {
                System.out.println("Enter the name of the hero:");
                tempS = src.nextLine();
                System.out.println(gameEngineServiceImpl.getAbilitiesByHeroName(tempS));
            }
        }
    }

    public static void getAbilities() {
        System.out.println("You want to get :\n" +
                "1.All abilities 2.Ability by name 3.Abilities by damage type");
        temp = src.nextInt();
        switch (temp) {
            case 1 -> System.out.println(gameEngineServiceImpl.getAllAbilities());
            case 2 -> {
                System.out.println("Enter the name of the ability:");
                src.nextLine();
                tempS = src.nextLine();
                System.out.println(gameEngineServiceImpl.getAbilityByName(tempS));
            }
            case 3 -> {
                System.out.println("Enter the damage type of the abilities(PHYSICAL, MAGICAL, PURE):");
                src.nextLine();
                tempS = src.nextLine();
                System.out.println(gameEngineServiceImpl.getAbilitiesByDamageType(tempS));
            }
        }
    }

}
