package Game;

import bean.*;
import org.lwjgl.input.Keyboard;
import utils.Window;

import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Game extends Window {

    private Bullet bullet;

    private Tank tank;
    //创建一个可以装很多墙的容器,ArrayList
    //private ArrayList<Wall> list = new ArrayList<>();
    public static CopyOnWriteArrayList<Element> list = new CopyOnWriteArrayList<>();

    public Game(String title, int width, int height, int fps) {
        super(title, width, height, fps);
    }

    /**
     * 初始化
     */
    @Override
    protected void onCreate() {
        int width = (Constants.WINDOW_WIDTH - Constants.ELEMENT_WIDTH) / 2;
        int height = Constants.WINDOW_HEIGHT - Constants.ELEMENT_HEIGHT;
        tank = new Tank(width, height);


        for (int i = 1; i < Constants.WINDOW_WIDTH / Constants.ELEMENT_WIDTH - 1; i++) {
            Wall wall = new Wall(i * Constants.ELEMENT_HEIGHT, Constants.ELEMENT_WIDTH * 2);
            //list.add(wall);
            addElement(wall);
        }

        for (int i = 0; i < Constants.WINDOW_WIDTH / Constants.ELEMENT_WIDTH - 6; i++) {
            Water water = new Water(i * Constants.ELEMENT_HEIGHT, Constants.ELEMENT_WIDTH * 3);
            //list.add(water);
            addElement(water);
        }

        for (int i = 3; i < Constants.WINDOW_WIDTH / Constants.ELEMENT_WIDTH - 2; i++) {
            Grass grass  = new Grass(i * Constants.ELEMENT_HEIGHT, Constants.ELEMENT_WIDTH * 5);
            //list.add(grass);
            addElement(grass);
        }

        for (int i = 4; i < Constants.WINDOW_WIDTH / Constants.ELEMENT_WIDTH - 4; i++) {
            Steel steel  = new Steel(i * Constants.ELEMENT_HEIGHT, Constants.ELEMENT_WIDTH * 7);
            //list.add(steel);
            addElement(steel);
        }

        addElement(tank);

    }

    /**
     * 鼠标监听
     */
    @Override
    protected void onMouseEvent(int key, int x, int y) {

    }

    /**
     * 键盘监听
     */
    @Override
    protected void onKeyEvent(int key) {
        if (key == Keyboard.KEY_W) {
            //调用坦克的移动功能
            tank.move(Direction.UP);
        } else if (key == Keyboard.KEY_S) {
            tank.move(Direction.DOWN);
        } else if (key == Keyboard.KEY_A) {
            tank.move(Direction.LEFT);
        } else if (key == Keyboard.KEY_D) {
            tank.move(Direction.RIGHT);
        } else if (key == Keyboard.KEY_SPACE) {
            //调用坦克发炮的方法
            bullet = tank.shot();
            if (bullet != null) {
                addElement(bullet);
            }
        }

    }

    /**
     * 显示刷新
     */
    @Override
    protected void onDisplayUpdate() {
        //tank.draw();

        for (Element element : list) {
            //判断e是否是子弹
            // instanceof 判断 a 是否为 b的数据类型
            if (element instanceof Bullet) {
                //判断子弹是否越界
                if (((Bullet) element).isDestroy()) {
                    //越界销毁子弹
                    list.remove(element);
                }
            }

            /*if (element instanceof Bullet && ((Bullet) element).isDestroy()) {
                list.remove(element);
            }*/

            element.draw();
            //System.out.println(list.size());
        }


    }

    public void addElement(Element e){
        //添加
        list.add(e);

        //排序
        Collections.sort(list, new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return o1.getLevel() - o2.getLevel();
            }
        });
    }
}
