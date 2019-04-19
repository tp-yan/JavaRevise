package ch13;

/* 使用动态规划DP实现Fibonacci数列
 * 递归算法是自顶向下求解问题，而在这里动态规划是自底向上求解。
 * 思路：首先求解子问题的解并进行$存储$，利用子问题的解求父问题的解，避免重复求解子问题
 * */

public class Code2_Fibon_DP {
    public static void main(String[] args) {
        System.out.println(Fibonacci(10));
        System.out.println(Fibonacci(33));
    }

    public static int Fibonacci(int n) {
        // 由数组a[]存储子问题的解
        int a[] = new int[1024];
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i <= n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n];
    }
}
