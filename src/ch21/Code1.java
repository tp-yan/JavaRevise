package ch21;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @Author: tp
 * @Date: 2019/4/18 21:19
 * @Description: Java中的异常处理机制有什么特点？
 * 1. 异常处理是Java中唯一的错误报告机制
 * 2. Java运行出错时，程序会通过 new 在堆上创建异常并从当前环境中弹出该对象的引用
 * 3. 在Java中，对异常的处理是强制的(Runtime Exception除外)，程序员必须对所有可能抛出的异常进行处理
 * Java异常处理的2种方法：
 * (1) 使用try-catch结构捕获并处理异常
 * (2) 在函数方法声明后使用throws列出可能抛出的异常来告知调用者
 *
 * Java中任何可以作为异常抛出的类都是Throwable类型，Throwable有两个子类Error：表示编译和系统错误(程序员无心关心)
 * Exception：可以被抛出的基本类型，其又有两个子类 运行时异常(也称为不受检查异常)RuntimeException和非运行时异常（检查异常）
 * Java中的异常处理是强制执行的，如果异常发生无法处理，则将异常传递至更高的层次，由高层处理这个异常。
 *
 * C语言中的异常：C语言的异常处理不属于语言的一部分，而是建立在约定俗成上，调用成功或失败的信息都包含在函数返回值中，
 * 函数返回某个特殊值由调用者对这个特殊值进行检查，判定是否发生异常。
 * 问题是若调用者不处理错误信息，则程序 * 则按照错误状态继续执行！
 *
 */

public class Code1 {
    public static void readFileWithTryCatch(){
        try {
            FileReader fileReader = new FileReader("test.txt");
            System.out.println("in try");
            // catch带一个Throwable类型的参数，表示可捕获异常类型
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("in catch");
        }finally {
            System.out.println("in finally");
        }
    }

    //  throws 告知方法的调用者，该方法可能会抛出的异常。这部分称为异常说明，属于方法声明的一部分。
    public static void readFileWithoutTryCatch() throws FileNotFoundException{
        FileReader reader = new FileReader("test.txt");
    }
}
