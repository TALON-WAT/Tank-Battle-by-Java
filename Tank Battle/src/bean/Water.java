package bean;

import Game.Constants;
import business.BlockAble;
import utils.DrawUtils;

import java.io.IOException;

/**
 * 水
 */
public class Water extends Element implements BlockAble {
    public Water(int x,int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        try {
            DrawUtils.draw(Constants.IMG_WATER,x,y);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
