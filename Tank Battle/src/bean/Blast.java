package bean;

import Game.Constants;
import Game.Game;
import utils.DrawUtils;

import java.io.IOException;

public class Blast extends Element {
    public Blast(Element e) {
        int blastWidth = 0;
        int blastHeight = 0;

        //获取爆炸物的宽高
        try {
            int[] arr = DrawUtils.getSize(Constants.IMG_BLAST_ARRAY[0]);
            blastWidth = arr[0];
            blastHeight = arr[1];

        } catch (IOException e1) {
            e1.printStackTrace();
        }

        //被击打元素的坐标
        int eX = e.getX();
        int eY = e.getY();
        //被击打元素的宽高
        int eWidth = Constants.ELEMENT_WIDTH;
        int eHeight = Constants.ELEMENT_HEIGHT;

        x = (int) (eX - (blastWidth - eWidth) / 2.0f + 0.5f);
        y = (int) (eY - (blastHeight - eHeight) / 2.0f + 0.5f);
    }

    @Override
    public void draw() {

        // 通过isBigBoom的值, 修改limit控制是否是大爆炸
        /*if(isBigBoom == true) {
            limit = 0;
        }else {
            limit = 3;
        }*/

        try {
            for(int i = 0; i < Constants.IMG_BLAST_ARRAY.length ; i++) {
                DrawUtils.draw(Constants.IMG_BLAST_ARRAY[i], x, y);
            }
            // 删除爆炸物
            Game.list.remove(this);
            //Game.list.remove(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
