package com.hjq.whyshare.test.java8;

/**
 * @Description
 * @Author hjq
 * @Date 2021/8/20
 */
public class ThreadState {

    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Runnable runnable = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread1 = new Thread(runnable);
        thread1.start();
        //为了让线程执行完
        Thread.sleep(2000);
        System.out.println(thread1.getState());
    }
}
