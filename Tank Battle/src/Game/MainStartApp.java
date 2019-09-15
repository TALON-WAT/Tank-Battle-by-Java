package Game;

/**
 *  游戏运行主方法
 */

public class MainStartApp {
    public static void main(String[] args) {
        String title = Constants.TITLE;
        int width = Constants.WINDOW_WIDTH;
        int height = Constants.WINDOW_HEIGHT;
        int fps = Constants.FPS;

        Game game = new Game(title,width,height,fps);
        game.start();

    }
}
