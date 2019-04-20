package ch22;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @Author: tp
 * @Date: 2019/4/19 13:14
 * @Description: throws还是try...catch？异常处理原则
 */
public class Code2 {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader reader = new FileReader("test.txt");
    }
}
