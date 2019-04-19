package ch19;

/**
 * @Author: tp
 * @Date: 2019/4/18 19:17
 * @Description: Java为什么不支持多继承？
 * 多继承：菱形继承问题，存在二义性。Java中使用接口代替多继承，因为实现接口的类，必须实现接口中的(抽象)方法,
 * 所以实现类调用的始终是自身类的方法实现，不存在二义性。
 */

class A {
    public void display() {

    }
}

class B extends A {
    @Override
    public void display() {
        System.out.println("B");
    }
}

class C extends A {
    @Override
    public void display() {
        System.out.println("C");
    }
}

/*
class D extends B, C {  // Java没有多继承，编译出错
}

public class Code {
    public static void main(String[] args) {
        D d = new D();
        // 因为B和C类中都有display的实现，而D自身没有，所以D对象调用display时无法确定该方法到底调用哪个父类的
        // 故 多继承会存在“二义性”
        d.display();
    }
}
*/