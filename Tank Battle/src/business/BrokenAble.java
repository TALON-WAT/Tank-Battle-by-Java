package business;

import bean.Blast;

/**
 * 能够被打碎
 */
public interface BrokenAble {
    //产生大爆炸
    Blast broken();
}
