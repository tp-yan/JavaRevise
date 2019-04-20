package ch22;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @Author: tp
 * @Date: 2019/4/19 10:45
 * @Description: throws还是try...catch？异常处理原则
 *  如果我们捕获的异常自己不知道如何处理，就不要catch(“吞食”)，而是throws，让高层去处理，让系统发现最早的错误。
 *  如果catch了异常而只是打印异常栈，相当于没有处理异常，而导致程序处于错误状态运行
 *  将所有的异常catch等于隐藏问题
 *
 */

public class Code1 {
    public static void main(String[] args) {
        try{
            FileReader reader = new FileReader("test.txt");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
