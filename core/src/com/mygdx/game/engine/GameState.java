package com.mygdx.game.engine;
public interface GameState {

    void create();
    void render();
    void destroy();
    void input();
    void update(double deltaTime);
}