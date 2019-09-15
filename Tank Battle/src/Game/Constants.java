package Game;
/*
    用来存放配置信息和常量
 */

import java.util.stream.Stream;

public class Constants {
    /**
     * 游戏标题 Game Title
     */
    public static final String TITLE = "Tank Battle 1.0";

    /**
     * 游戏屏幕的宽
     */
    public static final int WINDOW_WIDTH = 64 * 17;

    /**
     * 游戏屏幕的高
     */
    public static final int WINDOW_HEIGHT = 64 * 13;

    /**
     * 游戏屏幕的刷新率
     */
    public static final int FPS = 60;

    /**
     * 每一个元素的宽
     */
    public static final int ELEMENT_WIDTH = 64;

    /**
     * 每一个元素的高
     */
    public static final int ELEMENT_HEIGHT = 64;

    /**
     * 坦克的图片资源
     */
    public static final String IMG_TANK_UP = "res/img/tank_u.gif";
    public static final String IMG_TANK_DOWN = "res/img/tank_d.gif";
    public static final String IMG_TANK_LEFT = "res/img/tank_l.gif";
    public static final String IMG_TANK_RIGHT = "res/img/tank_r.gif";

    /**
     * 墙的图片资源
     */
    public static final String IMG_WALL = "res/img/wall.gif";

    /**
     * 水的图片资源
     */
    public static final String IMG_WATER = "res/img/water.gif";

    /**
     * 铁墙的图片资源
     */
    public static final String IMG_STEEL = "res/img/steel.gif";

    /**
     * 水的图片资源
     */
    public static final String IMG_GRASS = "res/img/grass.gif";

    /**
     * 子弹的图片资源
     */
    public static final String IMG_BULLET_UP = "res/img/bullet_u.gif";
    public static final String IMG_BULLET_DOWN = "res/img/bullet_d.gif";
    public static final String IMG_BULLET_LEFT = "res/img/bullet_l.gif";
    public static final String IMG_BULLET_RIGHT = "res/img/bullet_r.gif";

    /**
     * 爆炸物的图片资源
     */
    public static final String[] IMG_BLAST_ARRAY = {
            "res/img/blast_1.gif",
            "res/img/blast_2.gif",
            "res/img/blast_3.gif",
            "res/img/blast_4.gif",
            "res/img/blast_5.gif",
            "res/img/blast_6.gif",
            "res/img/blast_7.gif",
            "res/img/blast_8.gif"
    };

    /**
     * 游戏开始的音乐资源
     */
    public static final String MUSIC_START = "res/snd/start.wav";
    /**
     * 坦克射击的音乐资源
     */
    public static final String MUSIC_FIRE = "res/snd/fire.wav";
    /**
     * 子弹击中的音乐资源
     */
    public static final String MUSIC_HIT = "res/snd/hit.wav";
    /**
     * 爆炸的音乐资源
     */
    public static final String MUSIC_BLAST = "res/snd/blast.wav";
}
