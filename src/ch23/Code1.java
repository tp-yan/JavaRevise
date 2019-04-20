package ch23;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @Author: tp
 * @Date: 2019/4/20 10:35
 * @Description: Java输入输出流中使用到的装饰器模式
 */
public class Code1 {
    public static void main(String[] args) throws FileNotFoundException {
        // new FileInputStream()是一个 InputStream ，而new BufferedInputStream()也是一个InputStream
        // new BufferedInputStream 必须要有一个InputStream对象传入
        // BufferedInputStream给传入的对象动态添加了额外的功能，而不是为整个类添加一个功能，这就是装饰器模式
        // BufferedInputStream：将输入流包装成 缓冲输入流，可减少对磁盘访问率，提高读写效率
        InputStream inputStream = new BufferedInputStream(new FileInputStream("test.txt"));
    }
}
