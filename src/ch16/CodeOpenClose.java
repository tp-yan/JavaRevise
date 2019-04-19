package ch16;

/* 为什么需要编写类？这么做是不是使问题更复杂了？ */
/**
 * 面向过程的设计：没有将变化的东西与不变的东西进行分离。
 * 开闭原则：下面的 drawShapes 函数符合开闭原则
 * 1. 对于扩展开放：drawShapes 支持新增的任意继承自 Shape 的图形类
 * 2. 对于修改封闭： 在对模块进行扩展时（扩展 drawShapes 函数的行为，即新增Diamond类，而没有修改 drawShapes 的代码）
 * OO的三大特性：
 * 1. 封装：利用 抽象数据类型 将数据和基于数据的操作包装在一起，对外只提供部分接口
 * 2. 继承： 子类复用父类的功能，也可定义新的数据或新功能
 * 3. 多态：同一操作(一般是调用方法)作用于不同的对象(运行时对象)，可以有不同的解释，产生不同的执行结果，即相同的代码能依据
 * 运行时对象的不同而表现出不同的行为，尤其是通过指向父类的引用，实际调用的是子类中的方法。
 * 抽象：总结子类的共有特征并进行抽象，放于父类
 * 抽象与多态是 实现开闭原则的基础
 */


/**
 * 父类-抽象类
 */
abstract class Shape {
    public abstract void draw();
}

class Circle extends Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("This is a circle, radius = " + radius + ".");
    }
}

class Rectangle extends Shape {
    private int length;
    private int width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public void draw() {
        System.out.println("This is a rectangle, length = " + length + " width = " + width);
    }
}

class Triangle extends Shape {
    private int a;
    private int b;
    private int c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public void draw() {
        System.out.println("This is a triangle, a = " + a + " b = " + b + " c = " + c);
    }
}

/**
 * 菱形
 */
class Diamond extends Shape {
    private int length;

    public Diamond(int length) {
        this.length = length;
    }

    @Override
    public void draw() {
        System.out.println("This is a diamond, length = " + length);
    }
}

public class CodeOpenClose {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[4];
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(3, 4);
        shapes[2] = new Triangle(3, 4, 5);
        shapes[3] = new Diamond(3);

        drawShapes(shapes);
    }

    /**
     * drawShapes符合开闭原则：新增Diamond类，而不改变drawShapes的代码。
     */
    private static void drawShapes(Shape[] shapes) {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}
