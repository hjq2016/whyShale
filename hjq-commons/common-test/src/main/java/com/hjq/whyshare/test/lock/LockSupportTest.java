package com.hjq.whyshare.test.lock;

import com.mysql.cj.xdevapi.TableImpl;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Description
 * @Author hjq
 * @Date 2021/8/24
 */
public class LockSupportTest {

    public static void main(String[] args)  {
//        System.out.println(System.currentTimeMillis());
//        LockSupport.parkNanos(1000 * 1000 * 1000 * 3L);
//        System.out.println(System.currentTimeMillis());

        Object o = new Object();

        Thread t = Thread.currentThread();
//        new Thread(()-> {
//            System.out.println(t.getState());
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            synchronized (o) {
//                System.out.println(1111);
//            }
//            System.out.println(t.getState());
//            LockSupport.unpark(t);
//
//
//        }).start();
        LockSupport.unpark(t);
        LockSupport.unpark(t);
        LockSupport.unpark(t);
        LockSupport.park();
        LockSupport.park();
        LockSupport.park();

        System.out.println("hjq" + t.getState());
    }
}
