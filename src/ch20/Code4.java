package ch20;

/**
 * @Author: tp
 * @Date: 2019/4/18 21:14
 * @Description:
 */

// 假设需要使用文件系统进行存储，实现新的类FileDAOImpl
class FileDAOImpl implements ItemDAO{

    @Override
    public void save(Item item) {

    }

    @Override
    public String queryName(Item item) {
        return null;
    }
}

public class Code4 {
    public static void main(String[] args) {
        Item item = new Item(1,"TestItem1");
        // 只需要修改一行代码，使用 FileDAOImpl 替换到 DBDAOImpl即可，而无须修改其他部分
        ItemDAO dao = new FileDAOImpl();
        dao.save(item);
        String name = dao.queryName(item);
    }
}
