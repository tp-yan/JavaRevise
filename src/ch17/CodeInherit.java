package ch17;

/**
 * @Author: tp
 * @Date: 2019/4/18 10:29
 * @Description: 组合还是继承？如何选择？
 * 这里使用继承来实现 交通工具的设计，对比组合方式，发现 继承的缺点
 */

abstract class Vehicle {
    /* 使用子类的这个方法实现一样，故提取到父类中 */
    public void display() {
        // 打印(运行时)类名
        System.out.print(this.getClass().getSimpleName() + ":");
    }
    /* 子类的 travel实现各自不同，无法提取到父类中实现 */
    public abstract void travel();  // 打印交通工具的运行方式
}

class Bus extends Vehicle {
    @Override
    public void travel() {
        System.out.println("Run on the ground.");
    }
}

class Bike extends Vehicle {
    @Override
    public void travel() {
        System.out.println("Run on the ground.");
    }
}

class Plane extends Vehicle {
    @Override
    public void travel() {
        System.out.println("Fly in the sky.");
    }
}

class Helicopter extends Vehicle {
    @Override
    public void travel() {
        System.out.println("Fly in the sky.");
    }
}

/*
* 这里存在明显的问题：Bus、Bike以及Plane、Helicopter两个的travel()内容一模一样，即存在重复代码！！！
* 在编程时必须时刻遵守DRY原则(dont repeat yourself)!
* 这就是继承的缺点之一：缺乏弹性，子类自动拥有父类方法，而子类重写方法的代价很大，而且很可能出现重复代码，这是必须避免的！！
* */

public class CodeInherit {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[4];
        vehicles[0] = new Bus();
        vehicles[1] = new Bike();
        vehicles[2] = new Plane();
        vehicles[3] = new Helicopter();

        for (Vehicle vehicle : vehicles) {
            vehicle.display();
            vehicle.travel();
        }
    }
}
