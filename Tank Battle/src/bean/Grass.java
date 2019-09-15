package bean;

import Game.Constants;
import utils.DrawUtils;

import java.io.IOException;

/**
 * 草
 */
public class Grass extends Element {

    public Grass(int x,int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        try {
            DrawUtils.draw(Constants.IMG_GRASS,x,y);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getLevel(){
        return 2;
    }
}
