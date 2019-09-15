package bean;

import Game.Constants;
import business.AttackedAble;
import business.BlockAble;
import business.BrokenAble;
import utils.DrawUtils;

import java.io.IOException;

/**
 * 墙
 */
public class Wall extends Element implements BlockAble, AttackedAble, BrokenAble {
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
    public Blast Attacked() {
        //创造爆炸物对象并返回
        Blast blast = new Blast(this);
        return blast;
    }

    @Override
    public Blast broken() {
        Blast blast = new Blast(this,true);
        return blast;
    }
}
