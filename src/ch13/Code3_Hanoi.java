package ch13;

/*
 * Hanoi塔问题简述： 将A上的N个圆盘借助B移到C上，求需要移动的次数
 * 求解：问题分解：
 *       (1) 将A上的N-1个盘移动到B上
 *       (2) 将B上的N-1个盘再移动到C上
 *  以上即父问题分解为2个子问题
 *  Hanoi(n) = 2*Hanoi(n-1) + 1 ，Hanoi(1) = 1； 其中1：盘n由A-->C的一次操作
 * */

public class Code3_Hanoi {
    public static void main(String[] args) {
        System.out.println(Hanoi(10));
        System.out.println(Hanoi(2));
        HanoiPrint("A", "B", "C", 2);
        System.out.println(Hanoi(3));
        System.out.println("========================");
        HanoiPrint("A", "B", "C", 3);
        System.out.println("========================");
        System.out.println(Hanoi(4));
        HanoiPrint("A", "B", "C", 4);
    }

    public static int Hanoi(int n) {
        if (n == 1) {
            return 1;
        }
        return 2 * Hanoi(n - 1) + 1;

    }

    /* 打印盘移动过程
     * n个盘由A借助B移到C
     */
    public static void HanoiPrint(String A, String B, String C, int n) {
        if (n == 1) {
            System.out.println(n + " : " + A + " --> " + C);
        } else {
            HanoiPrint(A, C, B, n - 1);    // A上的n-1个盘借C移到B
            System.out.println(n + " : " + A + " --> " + C);    // A现在为空
            HanoiPrint(B, A, C, n - 1);                   // B上的n-1个盘借A移到C
        }
    }
}
