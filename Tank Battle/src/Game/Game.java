package Game;

import utils.Window;

public class Game extends Window {

    public Game(String title, int width, int height, int fps) {
        super(title, width, height, fps);
    }

    // 创建游戏界面的时候调用,只调用一次
    @Override
    protected void onCreate() {

    }

    // 鼠标监听,坐标起始位置为左下角
    @Override
    protected void onMouseEvent(int key, int x, int y) {
        System.out.println(key + ":" + x + "--" + y);
    }

    // 键盘监听
    @Override
    protected void onKeyEvent(int key) {

    }

    // 显示刷新
    @Override
    protected void onDisplayUpdate() {

    }
}
