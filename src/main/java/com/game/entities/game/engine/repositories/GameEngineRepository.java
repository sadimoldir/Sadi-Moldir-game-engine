package com.game.entities.game.engine.repositories;
import java.util.List;

public interface GameEngineRepository <T>{
    public List<T> findAll();
    public T findByName(String name);
}
