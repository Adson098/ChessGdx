package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.mygdx.game.core.PlayState;
import com.mygdx.game.engine.GameStateManager;
import com.mygdx.game.engine.ChessEngine;

public class Main extends ApplicationAdapter {
    GameStateManager gsm;
    ChessEngine gm;

    @Override
    public void create () {
        gsm = new GameStateManager();
        gm = new ChessEngine();
        gsm.push(new PlayState());

        try {
            gm.init(gsm);

        }
        finally {
            System.out.println("finally");
        }
    }

    @Override
    public void render () {

        gm.loop();
    }
}