package ch22;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @Author: tp
 * @Date: 2019/4/19 13:15
 * @Description: 异常处理3原则&转换为不受检查的异常：即不改变函数声明，又不吞食异常。
 * 受检查的异常必须由程序员处理，而不受检查的异常RuntimeException由系统处理
 *
 * 异常处理3原则：
 * 1. 具体明确
 * 2. 提早抛出
 * 3. 延迟捕获：只有我们知道如何处理这个异常时才去捕获它，否则抛出异常，交给高层调用者捕获
 */

public class Code3 {
    public static void main(String[] args) {
        try{
            FileReader reader = new FileReader("test.txt");
        }catch (FileNotFoundException e){
            throw new RuntimeException(e);  // 转换为不受检查的异常，main函数不用再声明可能抛出的异常类型
        }
    }
}

