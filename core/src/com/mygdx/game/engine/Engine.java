package com.mygdx.game.engine;

public interface Engine {

    void init(GameStateManager gsm);
    void loop();
    void update();

}