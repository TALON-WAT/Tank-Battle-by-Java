package bean;

import Game.Constants;
import Game.Game;
import business.AttactedAble;
import utils.CollsionUtils;
import utils.DrawUtils;

import java.io.IOException;

public class Bullet extends Element {

    /**
     * 子弹的攻击力
     */
    private int power = 25;

    /**
     * 子弹的速度
     */
    private int speed = 6;

    /**
     * 子弹的方向
     * @param tank
     */
    Direction direction;


    public Bullet(Tank tank) {
        //子弹的坐标和坦克的坐标有关联
        //设置子弹的坐标
        this.x = tank.x + tank.x / 4;
        this.y = tank.y - tank.y/4;

        //坦克的方向
        direction = tank.getDirection();

        int tankX = tank.getX();
        int tankY = tank.getY();
        int tankWidth = Constants.ELEMENT_WIDTH;
        int tankHeight = Constants.ELEMENT_HEIGHT;

        int bulletWidth = 0;
        int bulletHeight = 0;

        try {
            int[] size = DrawUtils.getSize(Constants.IMG_BULLET_UP);
            bulletWidth = size[0];
            bulletHeight = size[1];
        } catch (IOException e) {
            e.printStackTrace();
        }
        //计算坐标
        switch (direction) {

            case UP:
                x = (int) (tankX + (tankWidth - bulletWidth) / 2.0f + 0.5f);
                y = (int) (tankY - bulletHeight / 2.0f + 0.5f);
                break;
            case DOWN:
                x = (int) (tankX + (tankWidth - bulletWidth) / 2.0f + 0.5f);
                y = (int) (tankY + tankHeight - bulletHeight / 2.0f + 0.5f);
                break;
            case LEFT:
                x = (int) (tankX - bulletWidth / 2.0f + 0.5f);
                y = (int) (tankY + (tankHeight- bulletHeight) / 2.0f + 0.5f);
                break;
            case RIGHT:
                x = (int) (tankX + tankWidth - bulletWidth / 2.0f + 0.5f);
                y = (int) (tankY + (tankHeight- bulletHeight) / 2.0f + 0.5f);
                break;

        }
    }

    @Override
    public void draw() {
        //检测碰撞
        for (Element e : Game.list) {
            if (checkAttact(e)) {
                System.out.println("shot in " + e.getClass().getName());
                return;
            }
        }


        //根据不同的方向,画不同的子弹
        switch (direction) {

            case UP:
                try {
                    y -= speed;
                    DrawUtils.draw(Constants.IMG_BULLET_UP,x,y);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case DOWN:
                try {
                    y += speed;
                    DrawUtils.draw(Constants.IMG_BULLET_DOWN,x,y);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case LEFT:
                try {
                    x -= speed;
                    DrawUtils.draw(Constants.IMG_BULLET_LEFT,x,y);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case RIGHT:
                try {
                    x += speed;
                    DrawUtils.draw(Constants.IMG_BULLET_RIGHT ,x,y);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    /**
     * 此方法用来判断子弹是否应该被销毁
     */
    public boolean isDestroy() {
        return  x < 0 || y < 0 || x > Constants.WINDOW_WIDTH || y > Constants.WINDOW_HEIGHT;
    }

    public boolean checkAttact(Element e) {
        //过滤碰撞
        if (!(e instanceof AttactedAble)) {
            return false;
        }

        //1 element
        int x1 = e.getX();
        int y1 = e.getY();
        int w1 = Constants.ELEMENT_WIDTH;
        int h1 = Constants.ELEMENT_HEIGHT;

        //2 bullet
        int x2 = x;
        int y2 = y;
        int w2 = 8;
        int h2 = 8;


         boolean isAttact = CollsionUtils.isCollsionWithRect(x1, y1, w1, h1, x2, y2, w2, h2);

        if (isAttact) {
            //销毁子弹
            Game.list.remove(this);

            //打中了墙
            if (e instanceof Wall) {

                //墙被击打,创建爆炸物对象
                Blast b = ((Wall) e).Attacted();


                //剩下的血量
                int blood2 = ((Wall) e).getBlood() - power;
                //赋值到当前血量
                ((Wall) e).setBlood(blood2);
                //判断销毁
                if (((Wall) e).getBlood() <= 0) {
                    b = ((Wall) e).broken();
                    Game.list.remove(e);
                }

                //添加到集合中
                Game.list.add(b);
            }


            //打中了铁
            if (e instanceof Steel) {
                //剩下的血量
                int blood2 = ((Steel) e).getBlood() - power;
                //赋值到当前血量
                ((Steel) e).setBlood(blood2);
                //判断销毁
                if (((Steel) e).getBlood() <= 0) {
                    Game.list.remove(e);
                }

            }
        }

        return isAttact;

    }

}
