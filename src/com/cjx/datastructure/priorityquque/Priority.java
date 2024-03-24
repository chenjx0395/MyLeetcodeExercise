package com.cjx.datastructure.priorityquque;

/**
 * @author cjx
 * @Description 优先级队列的优先级接口，队列元素要实现该接口
 * @date 2024/3/24 9:50
 **/
public interface Priority {

    /**
     * 返回元素的优先级大小
     * @return 优先级大小
     */
    int backPriority();

}
