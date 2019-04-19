package ch12;

public class Main {

    public static void createLinkList(LinkList L){
        L.next = null;
        for (int i = 0; i < 10; i++) {
            LinkList s = new LinkList();
            s.data = i;
            s.next = L.next;
            L.next = s;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        LinkList L = new LinkList();
        L.data = 0;
        createLinkList(L);
        /* 垃圾自动回收，不需要destroy方法 */
    }
}
