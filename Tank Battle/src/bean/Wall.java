package bean;

import Game.Constants;
import business.AttactedAble;
import business.BlockAble;
import business.BrokenAble;
import utils.DrawUtils;

import java.io.IOException;

public class Wall extends Element implements BlockAble, AttactedAble , BrokenAble {
    //属性
    /**
     * 血量
     */
    private int blood = 50;

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public Wall(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //行为

    /**
     * 画墙
     */
    public void draw() {
        try {
            DrawUtils.draw(Constants.IMG_WALL,x,y);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Blast Attacted() {
        Blast blast = new Blast(this);
        return blast;
    }

    @Override
    public Blast broken() {
        Blast blast = new Blast(this);
        return blast;
    }
}
