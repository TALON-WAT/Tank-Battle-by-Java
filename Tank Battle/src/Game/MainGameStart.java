package Game;

/**
 *      游戏开始的主方法
 */
public class MainGameStart {
    public static void main(String[] args) {
        Game game = new Game("Tank Battle 1.0",800,600,60);
        game.start();
    }
}
