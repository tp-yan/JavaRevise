package ch20;

/**
 * @Author: tp
 * @Date: 2019/4/18 20:08
 * @Description: 为什么要定义接口？接口有什么用？
 * 这里使用 依赖倒置原则 重写 Code1_2.java，利用接口interface实现高层模块与底层模块的分离
 * 解决方法：定义一个数据存储的接口【规范】增删改查等行为
 * 接口就是一种规范，降低了模块的耦合度。接口告诉我们这个接口是来做什么的，而不关心具体应该如果去做。
 * 面向接口编程：在编写具体的实现类之前，我们首先分析该类要实现哪些功能，抽象出该类的行为形成接口，而不分析具体如何去实现，
 * 这就是所谓的“面向接口编程”，而非面向实现编程。
 */

// 接口ItemDAO定义了数据存储类需要实现的功能，即规范行为
interface ItemDAO {
    void save(Item item);   // 还是使用Code1_2.java中定义的 数据类Item

    String queryName(Item item);
}

// DBDAOImpl实现了ItemDAO，故依赖于ItemDAO。将DBDAOImpl隐藏在抽象接口ItemDAO后面，可以隔离DBDAOImpl的不稳定性
class DBDAOImpl implements ItemDAO {
    @Override
    public void save(Item item) {
    }

    @Override
    public String queryName(Item item) {
        return null;
    }
}

public class Code3_DAO {
    public static void main(String[] args) {
        Item item = new Item(1, "TestItem1");
        // 在main函数中定义ItemDAO，故main也是依赖于ItemDAO，符合依赖倒置原则
        // 使用接口ItemDAO实现 底层实现DBDAOImpl与高层模块 main函数分离
        ItemDAO dao = new DBDAOImpl();
        dao.save(item);
        String name = dao.queryName(item);
    }
}
