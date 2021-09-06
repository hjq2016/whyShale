package com.hjq.whyshare.test.mq;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description
 * @Author hjq
 * @Date 2021/8/24
 */
public class MqTest {

    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.add(1);
        deque.addFirst(2);
        System.out.println(deque.removeFirst());
        deque.stream().forEach(e-> System.out.println(e));
    }


}

