package ch17;

/**
 * @Author: tp
 * @Date: 2019/4/18 10:43
 * @Description: 组合还是继承？如何选择？
 * 使用组合实现与CodeInherit同样的功能，解决继承的问题：子类存在重复代码，缺乏弹性！

* 策略模式：
* 我们定义的一系列算法，将其封装到一个个类中，每个类拥有自己的策略，这些类实现相同的接口，因此任意两个类都可以相互替换。
* 以这种方法封装的算法称为一个策略。
* 优势：使算法的替换变得容易，若将算法硬编码进使用它们的类，将缺乏弹性

* 组合与继承
* 继承：父类的实现对子类是可见的，故称为白盒复用。
*       在编译时刻静态定义的，为静态复用，在编译后子类和父类的关系就已确定了
* 组合：要求建立一个好的接口。整体类(NewVehicle)和部分类(TravelMethod)之间的实现细节是不可见的，故称为黑盒复用。
*       整体类与部分类之间的关系在运行时才确定，即在对象创建之前，整体类是不知道自己持有特定接口下的哪个实现类。
* 比较：能够动态复用（运行时改变策略），组合更优弹性，解决继承的重复代码问题，而且是低耦合的。
*       更有助于保持每个类的封装，使得类的设计聚集于单个任务上，符合类设计的单一职责原则。
* */


/*
 * Bus、Bike具有相同的运行方式A
 * Plane、Helicopter具有相同的运行方式B
 * 而AB不相同，无法抽象到父类Vehicle中去实现
 * */

// 定义AB的共同接口，即运行方式
interface TravelMethod {
    public void operate();
}

// 将交通工具的各种运行方式从函数中提取出来形成各种策略
// 将每种策略封装到对应的类中(GroundMethod、SkyMethod)，这些类具有相同的接口(TravelMethod)，互相之间可以替换

class GroundMethod implements TravelMethod {
    // 每一种运行方式的实现(即策略)，在各自类中实现
    @Override
    public void operate() {
        System.out.println("Run on the ground.");
    }
}

class SkyMethod implements TravelMethod {
    @Override
    public void operate() {
        System.out.println("Fly in the sky.");
    }
}

abstract class NewVehicle {
    // 每一种交通工具拥有自己的运行策略
    private TravelMethod travelMethod;

    // 所用交通工具的 newTravel实现是一样的，故提取到父类中实现。子类只需要设置自己的运行策略即可
    public void newTravel() {
        travelMethod.operate();
    }

    public void setTravelMethod(TravelMethod travelMethod) {
        this.travelMethod = travelMethod;
    }

    public void display() {
        System.out.println(this.getClass().getSimpleName() + ":");
    }
}

class NewBus extends NewVehicle {
    public NewBus() {
        setTravelMethod(new GroundMethod());
    }
}

class NewBike extends NewVehicle {
    public NewBike() {
        setTravelMethod(new GroundMethod());
    }
}

class NewPlane extends NewVehicle {
    public NewPlane() {
        setTravelMethod(new SkyMethod());
    }
}


class NewHelicopter extends NewVehicle {
    public NewHelicopter() {
        setTravelMethod(new SkyMethod());
    }
}

public class CodeCombination {
    public static void main(String[] args) {
        NewVehicle[] vehicles = new NewVehicle[4];
        vehicles[0] = new NewBus();
        vehicles[1] = new NewBike();
        vehicles[2] = new NewPlane();
        vehicles[3] = new NewHelicopter();
        for (NewVehicle vehicle : vehicles
        ) {
            vehicle.display();
            vehicle.newTravel();
        }
        // 在运行时修改 策略 -- 交通工具的运行方式
        System.out.println("\nTravel method before change:");
        vehicles[0].display();
        vehicles[0].newTravel();
        System.out.println("Travel method after change:");
        vehicles[0].setTravelMethod(new SkyMethod());
        vehicles[0].display();
        vehicles[0].newTravel();
    }
}
