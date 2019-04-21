package ch25;

/**
 * @Author: tp
 * @Date: 2019/4/20 12:18一带
 * @Description: 多线程并发执行，在共同操作共享资源时可能发生冲突collision。
 * 需要在多线程编程中规范对共享资源的访问，实现线程同步，这就需要借助“锁”来完成！
 * 锁的作用：将多线程对共享资源的并发访问串行化，从而避免共享资源数据不一致问题。
 * 锁的实现：线程在访问共享资源之前先获得该对象的锁，访问结束后释放该锁，其他线程才得再获得该锁。
 * synchronized的2种使用方式：
 * 1. synchronized方法：表示为这个方法加锁。当多个线程访问同一对象的synchronized方法时，在同一时刻只有一个线程能得到执行，
 *    其他的线程被阻塞。因为在执行synchronized方法前需要获得当前对象的对象锁，只有执行完该方法后才能释放该对象锁。
 * 2. synchronized块
 */

class Manipulator1{
    public int value;

    public Manipulator1(int value) {
        this.value = value;
    }

    public void decrease(){
        value--;
    }

    public void increase(){
        value++;
    }
}

class Manipulator2{
    public int value;

    public Manipulator2(int value) {
        this.value = value;
    }

    public synchronized void decrease(){
        value--;
    }

    public synchronized void increase(){
        value++;
    }
}

public class Code1_collision {
    private static final int COUNT = 10000;

    public static void main(String[] args) throws InterruptedException {
        Manipulator1 manipulator1 = new Manipulator1(0);
        // 一个任务对应一个线程
        Thread task1 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < COUNT; i++) {
                    manipulator1.decrease();
                }
            }
        };

        Thread task2 = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < COUNT; i++) {
                    manipulator1.increase();
                }
            }
        };

        task1.start();
        task2.start();
        // main函数所在线程调用 线程1,2的join方法，则等待线程1,2执行完毕后再执行后续内容
        task1.join();
        task2.join();
        System.out.println(manipulator1.value);     // 输出-302 而非0，故说明了多线程在操作共享资源出现的冲突问题
    }
}
