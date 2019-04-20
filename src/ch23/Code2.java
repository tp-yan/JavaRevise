package ch23;

/**
 * @Author: tp
 * @Date: 2019/4/20 10:39
 * @Description: 装饰器模式实现原理
 */

interface IBook{
    void open();
}

class CommonBook implements IBook{
    @Override
    public void open() {
        System.out.println("Book Content");
    }
}

class SuperBook implements IBook{
    private IBook book;

    public SuperBook(IBook book) {
        this.book = book;
    }

    @Override
    public void open() {
        book.open();
    }
}

class PaperWrappedBook extends SuperBook{
    // 父类中的 book 对子类是隐藏的
    public PaperWrappedBook(IBook book) {
        super(book);    // 子类构造器必先调用父类构造器，故需传入父类构造器所需参数
    }

    @Override
    public void open() {
        // 装饰器类添加的额外的功能
        System.out.println("Paper wrapped");
        super.open();
        System.out.println("Paper wrapped");
    }
}

class RedBook extends SuperBook{
    public RedBook(IBook book) {
        super(book);
    }

    @Override
    public void open() {
        System.out.println("Red");
        super.open();
        System.out.println("Red");
    }
}

public class Code2 {
    public static void main(String[] args) {
        // 装饰器类可以一直嵌套下去
        SuperBook book = new RedBook(new PaperWrappedBook(new CommonBook()));
        book.open();    // 实际调用的而是RedBook的open方法
    }
}
