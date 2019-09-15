package bean;

public abstract class Element {
    /**
     *  x 坐标
     */
    protected int x;

    /**
     *  y 坐标
     */
    protected int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     *  生成
     */
    public abstract void draw();

    /**
     * 等级
     * @return
     */
    public int getLevel(){
        return 1;
    }
}
