package MulThread_Research;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockMain {

    //多线程打印
    //无锁
    public static void Non_Print(){
        Object lock = new Object();
        for(int i = 0;i < 10;i++){
            int finalI = i;
            new Thread(new Runnable(){
                @Override
                public void run() {
                    for(int j = 0;j < 10;j++)
                        System.out.println("线程" + finalI + " 调用了" + j + "次");
                }
            }).start();
        }
    }
    //syn代码块
    public static void SynCode_Print(){
        for(int i = 0;i < 10;i++){
            int finalI = i;
            new Thread(new Runnable(){
                @Override
                public void run() {
                    for(int j = 0;j < 10;j++)
                        synchronized (LockMain.class){
                            System.out.println("线程" + finalI + " 调用了" + j + "次");
                        }
                }
            }).start();
        }
    }
    //syn装饰方法
    public static void SynDec_Print(){
        Object lock = new Object();
        for(int i = 0;i < 10;i++){
            int finalI = i;
            new Thread(new Runnable(){
                @Override
                public void run() {
                    for(int j = 0;j < 10;j++)
                        print(finalI,j);
                }
            }).start();
        }
    }
    //reenlock同步
    public static void ReenLock_Print(){
        Lock lock = new ReentrantLock(true);//可以在构造方法设置公平锁或非公平锁
        for(int i = 0;i < 10;i++){
            int finalI = i;
            new Thread(new Runnable(){
                @Override
                public void run() {
                    for(int j = 0;j < 10;j++){
                        lock.lock();
                        try{
                            System.out.println("线程" + finalI + " 调用了" + j + "次");
                        }catch (Exception e){
                            e.printStackTrace();
                        }finally {
                            lock.unlock();
                        }
                    }

                }
            }).start();
        }
    }

    //同步线程方法
    public static synchronized void print(int finalI,int j){
        System.out.println("线程" + finalI + " 调用了" + j + "次");
    }

    //启动
    public static void main(String[] args) {
        LockMain.SynCode_Print();
//        LockMain.Non_Print();
//        LockMain.ReenLock_Print();
//        LockMain.SynDec_Print();
    }
}
