package ch20;

/**
 * @Author: tp
 * @Date: 2019/4/18 19:36
 * @Description: 为什么要定义接口？接口有什么用？

 依赖倒置原则：
 1. 高层模块不应该依赖于底层模块，二者都应该依赖于抽象
 2. 抽象不应该依赖于细节，细节应该依赖于抽象
 */

// 数据对象类
class Item {
    public int id;
    public String name;

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

// 数据存储类：负责连接数据库，实现增删改查
class DBHandler {
    public void save(int id, String name) {
        // 实现数据存储于数据库
    }

    public String queryNameById(int id) {
        String ret;
        ret = "mock string";    // 模拟查询结果
        return ret;
    }
}

class DBHandler2 {
    public void save(Item item) {

    }

    public String queryName(Item item) {
        String ret;
        ret = "mock string";    // 模拟查询结果
        return ret;
    }
}


public class Code1_2 {
    public static void main(String[] args) {
        Item item = new Item(1, "TestItems");

        DBHandler handler = new DBHandler();
        handler.save(item.id, item.name);
        String name = handler.queryNameById(1);
        // 若DBHandler的save、queryNameById代码修改，那么程序中所有调用这两方法的代码都需要修改，工作量将巨大
        // 产生原因： 我们在应用程序中编写的大部分 具体类 都是不稳定的(即容易发生变化)，当高层模块(这个例子中是main函数)
        // 直接依赖于这些不稳定的底层模块(DBHandler类)，一旦底层模块发生变化，高层模块也要做出相应变化。
        DBHandler2 handler2 = new DBHandler2();
        handler2.save(item);
        String name2 = handler2.queryName(item);
    }
}
