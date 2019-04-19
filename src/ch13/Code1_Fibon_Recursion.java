package ch13;

/* 使用递归实现Fibonacci数列
 * 递归和动态规划都要求给出 ！递推公式！ 将大问题划分为相似子问题求解。
 * 而 动态规划比递归好处是：保存中间计算结果（子问题的解），去除重复计算！
 * 递归的特点：
 * (1) 外层往往需要内层计算结果：发现父问题与子问题的关系，具体问题具体实现
 * (2) 必须有一个明确的递归结束条件，称为递归出口！
  * */

public class Code1_Fibon_Recursion {
    public static void main(String[] args) {
        System.out.println(Fibonacci(10));
        System.out.println(Fibonacci(33));
    }

    /**
     * (1) 递推式 Finbo(n) = Finbo(n-1) + Finbo(n-2)
     * (2) 递归出口： Finbo(0) = 0, Finbo(1) = 1
     * 因为Fibonacci不断调用自身，则会不断形成栈帧压栈，如果层次太多，就会抛出stackoverflow异常
     */
    public static int Fibonacci(int n){
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        return Fibonacci(n-1) + Fibonacci(n-2);
    }
}


