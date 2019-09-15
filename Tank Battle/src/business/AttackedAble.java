package business;

import bean.Blast;

/**
 * 能被子弹击打的接口
 */
public interface AttackedAble {
    //能够产生爆炸物
    public abstract Blast Attacked();
}
