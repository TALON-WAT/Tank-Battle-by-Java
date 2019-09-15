package bean;

import Game.Constants;
import Game.Game;
import business.BlockAble;
import utils.CollsionUtils;
import utils.DrawUtils;

import java.io.IOException;

public class Tank extends Element {

    private long lastShotTime;

    private Direction badDirection;


    //属性
    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 血量
     */

    /**
     * 方向
     */
    private Direction direction = Direction.UP;

    /**
     * 速度
     */
    private int speed = 32;

    //行为

    /**
     * 坦克方向
     * @return
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * 坦克的生成功能 draw tank
     */
    public void draw() {
        try {
            //根据不同的方向,画不同的图片资源
            switch (direction) {
                case UP:
                    DrawUtils.draw(Constants.IMG_TANK_UP,x,y);
                    break;
                case DOWN:
                    DrawUtils.draw(Constants.IMG_TANK_DOWN,x,y);

                    break;
                case LEFT:
                    DrawUtils.draw(Constants.IMG_TANK_LEFT,x,y);

                    break;
                case RIGHT:
                    DrawUtils.draw(Constants.IMG_TANK_RIGHT,x,y);

                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 坦克的移动功能
     */
    public void move(Direction direction) {

        for (Element element : Game.list) {
            if (checkHit(element) && badDirection == direction) {
                System.out.println("撞上拉!~~");
                //如果碰上了 就停止移动
                return;
            }
        }

        //如果当前方向和要移动的方向不一致 -> 不动,只改变方向
        if (this.direction != direction) {
            //将局部变量的方向复制给成员变量
            this.direction = direction;
            //让其不动
            return;
        }


        //根据direction的朝向 移动
        switch (direction) {
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;

                break;
            case LEFT:
                x -= speed;

                break;
            case RIGHT:
                x += speed;

                break;
        }

        //检测边界
        checkOut();
    }

    /**
     * 检测坦克出界,并设置到边界的位置
     */
    public void checkOut() {
        if (x < 0) {
            x = 0;
        }

        if (y < 0) {
            y = 0;
        }

        if (x > Constants.WINDOW_WIDTH - Constants.ELEMENT_WIDTH) {
            x = Constants.WINDOW_WIDTH - Constants.ELEMENT_WIDTH;
        }
        if (y > Constants.WINDOW_HEIGHT - Constants.ELEMENT_HEIGHT) {
            y = Constants.WINDOW_HEIGHT - Constants.ELEMENT_HEIGHT;
        }
    }

    /**
     * 发炮
     */
    public Bullet shot() {
        long current = System.currentTimeMillis();
        if (current - lastShotTime > 500) {

            lastShotTime = current;
            //创建子弹对象
            Bullet bullet = new Bullet(this);
            //返回一个子弹对象
            return bullet;
        }

        return null;

    }

    /**
     * 检测坦克碰撞
     * @param //用来检测和坦克碰撞的元素
     * @return
     */
    public boolean checkHit(Element e) {
        //如果获取的元素,不和坦克产生碰撞
        if (!(e instanceof BlockAble)) {
            return false;
        }

        //1 element
        int x1 = e.getX();
        int y1 = e.getY();
        int w1 = Constants.ELEMENT_WIDTH;
        int h1 = Constants.ELEMENT_HEIGHT;

        //2 tank
        int x2 = x;
        int y2 = y;
        int w2 = Constants.ELEMENT_WIDTH;
        int h2 = Constants.ELEMENT_HEIGHT;

        //让检测碰撞时 坦克提前运动一次
        switch (direction) {
            case UP:
                y2 -= speed;
                break;
            case DOWN:
                y2 += speed;
                break;
            case LEFT:
                x2 -= speed;
                break;
            case RIGHT:
                x2 += speed;
                break;
        }

        boolean isHis = CollsionUtils.isCollsionWithRect(x1, y1, w1, h1, x2, y2, w2, h2);

        //如果撞上了 将坦克设置到边界
        if (isHis) {

            //将当前的方向赋值给即将撞上的方向
            badDirection = direction;

            switch (direction) {
                case UP:
                    y = y1 + h1;
                    break;
                case DOWN:
                    y = y1  - h2;

                    break;
                case LEFT:
                    x = x1 + w1;

                    break;
                case RIGHT:
                    x = x1 - w2;

                    break;
            }
        }

        return isHis;
    }

}
