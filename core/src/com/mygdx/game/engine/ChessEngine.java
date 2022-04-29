package com.mygdx.game.engine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.ScreenUtils;

public class ChessEngine implements Engine {


    private GameStateManager gsm;
    private double secPerframe = 1000.0d/50.0d;
    private double secPerUpdate = 1000.0d;
    private double previous = Gdx.graphics.getDeltaTime();
    double steps = 0.0;

    public ChessEngine(){
    }

    public void init(GameStateManager gsm) {
        this.gsm = gsm;

        gsm.peek().create();

    }

    @Override
    public void loop() {



            double loopStartTime = Gdx.graphics.getDeltaTime();
            double elapsed = loopStartTime- previous;
            previous = loopStartTime;
            steps += elapsed;
            gsm.peek().input();

            while(steps >= secPerUpdate){
                gsm.peek().update(steps);
                steps -= secPerUpdate;
            }
            ScreenUtils.clear(0,0,0,0);
            gsm.peek().render();
        }



    @Override
    public void update() {

    }
}