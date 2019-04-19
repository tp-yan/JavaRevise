package ch18;

/**
 * @Author: tp
 * @Date: 2019/4/18 11:36
 * @Description: 为什么静态方法不能调用非静态成员？
 *  假设静态方法中调用非静态数据成员，若存在多个对象，则静态方法无法确定应该关联到哪个对象，甚至此时不存在对象，所以不允许
 *  调用非静态数据成员。
 *  非静态方法可以调用静态方法与数据成员
 */

class Bike {
    // 非静态成员是属于对象的，静态成员是属于类的
    public int size;
    public int weight;
    // 在类加载时，完成初始化，且只进行一次初始化，因为编译后类只加载一次
    private static int count = 0;   // 静态数据成员 属于类，即类成员

    public Bike(int size, int weight) {
        this.size = size;
        this.weight = weight;
        count++;
    }
    // 静态方法即类方法
    public static void displayCount() {
        System.out.println("There are " + count + " bikes in total.");
    }
}

public class CodeStatic {
    public static void main(String[] args) {
        // 静态方法的调用依赖于类，而不依赖于对象
        Bike.displayCount();    // 创建对象前，调用类方法
        Bike bike1 = new Bike(10,100);
        Bike.displayCount();
        Bike bike2 = new Bike(10,200);
        Bike.displayCount();
    }
}
