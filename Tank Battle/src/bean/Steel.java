package bean;

import Game.Constants;
import business.AttackedAble;
import business.BlockAble;
import business.BrokenAble;
import utils.DrawUtils;

import java.io.IOException;

/**
 * 铁
 */
public class Steel extends Element implements BlockAble , AttackedAble, BrokenAble {
    /**
     * 血量
     */
    private int blood = 100;

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public Steel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        try {
            DrawUtils.draw(Constants.IMG_STEEL,x,y);
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
